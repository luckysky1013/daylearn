package com.spring.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liujian
 * @date 2018/9/4
 */
public class Input {

	public static void main(String[] args) {
		try {
			String  path=Input.class.getClassLoader().getResource("data/1.txt").getPath();
			InputStream is = new FileInputStream(Input.class.getClassLoader().getResource("data/1.txt").getPath());

			//方法2：定义数组，循环读取
			//先定义一个字节数组存放数据
			byte[] b = new byte[5];//把所有的数据读取到这个字节当中
			//声明一个int存储每次读取到的数据
			int i = 0;
			//定义一个记录索引的变量
			int index = 0;
			//循环读取每个数据
			while ((i = is.read()) != -1) {//把读取的数据放到i中
				b[index] = (byte) i;
				index++;
			}
			//把字节数组转成字符串
			System.out.println(new String(b));
			//关闭流
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
