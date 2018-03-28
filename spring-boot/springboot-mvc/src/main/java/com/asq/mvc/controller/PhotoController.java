package com.asq.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liujian
 * @date 2018/3/13
 */
@Controller
public class PhotoController {

	private final static Logger logger=Logger.getLogger(String.valueOf(PhotoController.class));

	@RequestMapping(value = "/photos")
	@ResponseBody
	public String createFolw(HttpServletRequest request,HttpServletResponse response,Model model){
		FileInputStream fis=null;
		OutputStream os=null;

		try {
			fis=new FileInputStream("/photo");
			os=response.getOutputStream();
			int count=0;
			byte[] buffer=new byte[1024*8];
			while((count=fis.read())!=-1){
				os.write(buffer,0,count);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			fis.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ok";

	}

}
