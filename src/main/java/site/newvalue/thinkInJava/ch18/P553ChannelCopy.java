package site.newvalue.thinkInJava.ch18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class P553ChannelCopy {
    private static final int BSIZE=1024;

    public static void main(String[] args) throws IOException {
        String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        FileChannel in=new FileInputStream(path+"/"+"a.txt").getChannel(),out= new FileOutputStream(path+"/b.txt").getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        while (in.read(buff)!=-1){
            buff.flip();
            out.write(buff);
            buff.clear();
        }
        in.close();
        out.close();
        System.out.println(path);
    }
}
