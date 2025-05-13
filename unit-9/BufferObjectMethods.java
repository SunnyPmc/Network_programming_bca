import java.nio.ByteBuffer;

public class BufferObjectMethods {
    public static void main(String[] args) {
        // Create two buffers with same content
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        ByteBuffer buffer2 = ByteBuffer.allocate(5);

        // Fill both with the same data
        for (byte i = 1; i <= 5; i++) {
            buffer1.put(i);
            buffer2.put(i);
        }

        // Prepare both for reading
        buffer1.flip();
        buffer2.flip();

        // equals()
        System.out.println("Are buffers equal? " + buffer1.equals(buffer2));

        // hashCode()
        System.out.println("Buffer1 hashCode: " + buffer1.hashCode());
        System.out.println("Buffer2 hashCode: " + buffer2.hashCode());

        // compareTo()
        int result = buffer1.compareTo(buffer2);
        if (result == 0) {
            System.out.println("Buffers are equal using compareTo()");
        } else if (result < 0) {
            System.out.println("Buffer1 is less than Buffer2");
        } else {
            System.out.println("Buffer1 is greater than Buffer2");
        }

        // toString()
        System.out.println("Buffer1 info: " + buffer1.toString());
        System.out.println("Buffer2 info: " + buffer2.toString());
    }
}
