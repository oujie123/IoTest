package com.example.ioproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/7/25 16:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/25 16:23
 * @UpdateRemark: 更新说明
 */
public class FileChannelTest {


    public static void main(String[] args) {
        String sourcePath = "1.mp4";
        String desPath = "/des/1.mp4";
    }

    public static void operateByStream(String path, String desPath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(path));
        FileOutputStream fos = new FileOutputStream(new File(desPath));

        byte[] buffer = new byte[1024 * 1024];
        while (fis.read(buffer) != -1) {
            fos.write(buffer);
        }

        fis.close();
        fos.close();
    }

    public static void operateByChannel(String path, String desPath) throws IOException {
        FileChannel sfc = new FileInputStream(new File(path)).getChannel();
        FileChannel dfc = new FileOutputStream(new File(desPath)).getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        while (sfc.read(byteBuffer) != -1){
            //读完数据指针在尾部，需要调用flip跳转到头部
            byteBuffer.flip();
            dfc.write(byteBuffer);
            byteBuffer.clear();
        }

        sfc.close();
        dfc.close();
    }
}
