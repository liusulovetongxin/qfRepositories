package com.qf.myTest;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package com.qf.myTest
 * @Description:
 * @Date 2022/7/4 20:20
 */

public class nio01 {


    // 失败，看来不是这样写的
//    public static void main(String[] args) throws Exception {
////        ByteBuffer buffer = ByteBuffer.allocate(1024);
////        FileOutputStream fos = new FileOutputStream("teststring.txt");
////        FileChannel channel = fos.getChannel();
////        buffer.put("试一试看看能不能放进去".getBytes(StandardCharsets.UTF_8));
////        buffer.flip();
////        channel.write(buffer);
////        fos.close();
//
//        FileInputStream fis = new FileInputStream("teststring.txt");
//        FileChannel channel = fis.getChannel();
//
//        ByteBuffer buffer = ByteBuffer.allocate(10);
//
//        byte[] bytes = new byte[1024];
//        int bytesi = 0;
//        while(true) {
//            buffer.clear();
//            int read = channel.read(buffer);
//            if (read==-1){
//                break;
//            }
//            buffer.flip();
//            CharBuffer charBuffer = buffer.asCharBuffer();
//            char c = charBuffer.get();
//            System.err.println(c);
//        }
//
//        String s = new String(bytes, Charset.forName("utf-8"));
//        System.err.println(s);

//    }

//    public static void main(String[] args) throws Exception {
//        FileInputStream fis = new FileInputStream("teststring.txt");
//        FileChannel channel = fis.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        channel.read(buffer);
//
//        buffer.flip();
//
//        Charset charset = Charset.forName("utf-8");
//        CharBuffer charBuffer = charset.decode(buffer);
//        String s = charBuffer.toString();
//        System.err.println(s);
//        fis.close();
//
//        System.err.println(buffer.limit());
//
//
//    }



}