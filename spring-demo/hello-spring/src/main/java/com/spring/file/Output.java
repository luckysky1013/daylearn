package com.spring.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liujian
 * @date 2018/9/3
 */
public class Output {

	public static void main(String [] args) {
		Output output=new Output();
		output.output();
	}

	public void output() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					this.getClass().getResource("").getPath()));
			byte[] bytes = new byte['2'];
			fileOutputStream.write(bytes);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
