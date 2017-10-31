package com.zs;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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

    }


}
