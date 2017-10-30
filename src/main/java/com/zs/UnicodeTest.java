package com.zs;

import java.io.UnsupportedEncodingException;

/**
 * User: chanson-pro
 * Date-Time: 2017-10-30 23:26
 * Description:不同编码格式，中英文所占字节数不同
 */
public class UnicodeTest {
    public static void main(String[] args) throws Exception {
        System.out.println("默认编码格式为utf-8");
        String str = "北京ABC";//默认utf-8编码格式
        byte[] bytes =str.getBytes();//将字符串转化成字节码
        for(byte aByte: bytes){
            System.out.print(Integer.toHexString(aByte &0xff)+" ");//输出16进制字节码
        }
        // utf-8编码，中文占3个字节，英文占1一个字节
        System.out.println("设置编码格式为：gbk");
        byte[] bytes1 = str.getBytes("gbk");
        for (byte bByte:bytes1){
            System.out.print(Integer.toHexString(bByte &0xff)+" ");
        }
        System.out.println();
        // java编码默认是占两个字节，编码格式为utf-16be
        byte[] bytes2 = str.getBytes("utf-16be");
        for (byte cByte:bytes2) {
            System.out.print(Integer.toHexString(cByte & 0xff)+" ");
        }
        System.out.println();
        /**
         * 字节序列是某种编码时，这个时候想把字节序列变成字符串，
         * 也需要用这种编码方式，否则会出现乱码！
         */
        String string = new String(bytes2);
        System.out.println(string);
        String string1 = new String(bytes2,"utf-16be");
        System.out.println(string1);
        /**
         * 文本文件就是字节序列
         * 文本文件可以是任意编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，
         * 那么该文本文件只认识ansi编码，
         * 但是复制来的其他文本文件会被自动转换
         */

    }


}
