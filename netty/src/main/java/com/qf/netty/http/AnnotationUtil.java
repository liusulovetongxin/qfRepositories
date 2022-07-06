package com.qf.netty.http;

import com.qf.netty.http.anno.RequestMapping;
import com.qf.netty.http.anno.RestController;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author Administrator
 * @version V1.0
 * @Project netty
 * @Package com.qf.netty.http.controller
 * @Description:
 * @Date 2022/7/6 16:41
 */

public class AnnotationUtil {

    private static Map<String,Method> url2method = new HashMap<>();

    private static Map<String,Object> url2object = new HashMap<>();
    public static void inject(){
        System.err.println("AnnotationUtil类中的inject方法执行了-->");
        // 开启异步，扫包
        CompletableFuture.runAsync(()->{
            // 找到当前类的所在包名
            String pacName = AnnotationUtil.class.getPackage().getName();
//            System.err.println(pacName);
            // 包名转换为地址名字
            String pacPath = pacName.replaceAll("\\.", "/");
//            System.err.println(pacPath);
            // 找到当前项目所在的地址路径
            URL url = AnnotationUtil.class.getClassLoader().getResource(".");
//            System.err.println(url);
            if (url.getProtocol().startsWith("file")){
                // 将url地址转换为可以识别的地址路径
                String basePath = url.getPath();
//                System.err.println(basePath);
                // 通过地址拼接来找到当前项目当前包中的所有文件
                File file = new File(basePath+pacPath);
                getFile(file,pacName);
//                System.err.println(url2method);
//                System.err.println(url2object);
            }
        });

    }

    public static void getFile(File file,String pacName){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                getFile(file1,pacName+"."+file1.getName());
            }else {
                String file1Name = file1.getName();
//                System.err.println(className);

                // 拿到了类的全名称
                String replace = file1Name.replace(".class", "");
                String className = pacName +"."+ replace;

                // 通过类的全名称来反射，反射到每一个类
                Class<?> aClass = null;
                try {
//                    System.err.println(className);
                    aClass = Class.forName(className);
                    // 反射拿到restcontroller的注解 如果拿到，就说明是controller，如果那不到就不是
                    RestController restController = aClass.getAnnotation(RestController.class);
                    if (restController != null) {
//                        System.err.println(className);
                        Object controller = aClass.newInstance();
                        String basePath = "";
                        // 获取到requsetmapping注解
                        RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
                        if (requestMapping != null) {
                            basePath = requestMapping.value();
//                            System.err.println(basePath);
                            Method[] methods = aClass.getMethods();
                            for (Method method : methods) {
                                RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                                if (mapping != null) {
                                    String realPath = basePath +mapping.value();
//                                    System.err.println(realPath);
                                    url2method.put(realPath,method);
                                    url2object.put(realPath, controller);
                                }
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    public static Method  getMethod(String url){
        return url2method.get(url);
    }

    public static Object  getObject(String url){
        return url2object.get(url);
    }
}
