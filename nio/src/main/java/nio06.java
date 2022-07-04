import java.nio.ByteBuffer;

/**
 * @author Administrator
 * @version V1.0
 * @Project nio
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/7/4 17:10
 */

public class nio06 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        buffer.position(2);
        buffer.limit(6);
        ByteBuffer newBuffer = buffer.slice();
        for (int i = 0; i < newBuffer.capacity(); i++) {
            byte b = newBuffer.get();
//            System.err.println((int) b);
            newBuffer.put(i, (byte) (b*2));
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()){
            byte b = buffer.get();
            System.err.println(((int) b));
        }
    }
}
