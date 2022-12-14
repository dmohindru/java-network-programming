package Ch11NonblockingIO.Buffers;

import java.nio.CharBuffer;

public class BufferExperiment {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(12);
        int size = buffer.capacity();
        int limit = buffer.limit();
        int pos = buffer.position();
        System.out.printf("Before pushing data size: %d, limit: %d, pos: %d\n", size, limit, pos);
        buffer.put( 'H');
        buffer.put( 'e');
        buffer.put( 'l');
        buffer.put( 'l');
        buffer.put('o');
        String result = "";
        // read data
//        while (buffer.hasRemaining()) {
//            result += buffer.get();
//        }
        System.out.println("reading data before flip: " + result);
        size = buffer.capacity();
        limit = buffer.limit();
        pos = buffer.position();
        System.out.printf("After pushing data size: %d, limit: %d, pos: %d\n", size, limit, pos);
        buffer.flip();
        size = buffer.capacity();
        limit = buffer.limit();
        pos = buffer.position();
        System.out.printf("After flip size: %d, limit: %d, pos: %d\n", size, limit, pos);

        // read data after flip
        result = "";
        while (buffer.hasRemaining()) {
            result += buffer.get();
        }
        System.out.println("reading data after flip: " + result);


    }
}
