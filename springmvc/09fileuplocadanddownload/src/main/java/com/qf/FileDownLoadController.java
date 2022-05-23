package com.qf;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf
 * @Description:
 * @Date 2022/5/23 20:28
 */
@Controller
public class FileDownLoadController {
    @RequestMapping("/download")
    public void download(String name, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath("/pic");//获取项目运行期间的一个目录,这个目录在项目中
        String filePath = realPath + File.separator + name;//假设这就是我们的目标文件的查找方式
        //告诉客户端这个文件叫什么名字
        try {
            // URLEncoder的目的是编码一些非纯字母的文件 比如有汉字等
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(name,"UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            IOUtils.copy(new FileInputStream(filePath), response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
