import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 15:55
 */

public class nio08 {
    public static void main(String[] args)throws Exception {
        FileInputStream fileInputStream = new FileInputStream("testinout.txt");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("ceshiinout.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        while (true){
            buffer.clear();
            int read = fileInputStreamChannel.read(buffer);

            if (read==-1){
                break;
            }
            buffer.flip();
            fileOutputStreamChannel.write(buffer);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }
}
