package com.springmvc.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {
	
	@RequestMapping(value="index")
	public String file(){
		return "filedownload";	
	}
	
	@RequestMapping(value="download.do")
	public ResponseEntity<byte[]> download() throws Exception {
		File file = new File("C:\\12.jpg");
		//http头信息
		HttpHeaders headers = new HttpHeaders();
		//设置下载文件名
		String fileName=new String("测试下载.jpg".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers,HttpStatus.CREATED);
	}

}
