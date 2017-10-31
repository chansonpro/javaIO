package com.zs;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * User: chanson-pro
 * Date-Time: 2017-10-31 11:12
 * Description: 使用RandAccessFile(),读写文件内容。注意，每次写只能写1个字节！
 */
public class RafDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if(!demo.exists()){
            demo.mkdir();
        }
        File file = new File(demo,"raf.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        //指针的位置
        System.out.println(raf.getFilePointer());
        raf.write('联');
        System.out.println(raf.getFilePointer());
        int i = 0x7fffffff;

        raf.writeInt(i);
        System.out.println(raf.getFilePointer());
        raf.seek(1);
        String str = "中国人民！";
        byte[] bytes = str.getBytes("utf-8");
        //采用字节数组做参数，一次不仅可以写入一个汉字，可以写入一串汉字！
        raf.write(bytes);
        System.out.println(raf.getFilePointer());
        // [2]读文件内容，注意，读文件，必须把指针移到文件头部
        raf.seek(0);
        // 一次性读取，把读取到的内容保存到字节数组中
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);

        System.out.print(Arrays.toString(buf)+" ");
        System.out.println();
        // 16进制输出
        for (byte b:buf) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        // 最后，关闭
        raf.close();


    }


}
