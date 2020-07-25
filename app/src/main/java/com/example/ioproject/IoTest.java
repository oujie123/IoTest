package com.example.ioproject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/7/25 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/25 9:23
 * @UpdateRemark: 更新说明
 */
public class IoTest {

    public static void main(String[] args) throws Exception {
//        writeByte();
//        readbyte();
        write();
        read();
    }

    /**
     * 使用字符流写
     */
    public static void write() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("test2.txt")),"UTF-8"));
        bw.write("Jack ou In guangzhou. 唱着歌唱祖国 \r\n");
        bw.write("Jack ou In guangzhou. 唱着义勇军进行曲");
        bw.flush();
        bw.close();
    }

    /**
     * 使用字符流读
     */
    public static void read() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("test2.txt")),"UTF-8"));
        String s = "";
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }
        br.close();
    }

    /**
     * 使用字节流写
     */
    public static void writeByte() {
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test.txt"))));
            outputStream.writeBoolean(true);
            outputStream.writeByte((byte) 0x32);
            outputStream.writeChar((char) 0x4243);
            outputStream.writeShort((short) 0x4532);
            outputStream.writeInt(0x36454122);
            outputStream.writeLong(0x34564564561L);
            outputStream.writeUTF("Jack Ou is 帅！\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用字节流读
     */
    public static void readbyte(){
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("test.txt"))));
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readChar());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readUTF());
            //System.out.println(inputStream.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
