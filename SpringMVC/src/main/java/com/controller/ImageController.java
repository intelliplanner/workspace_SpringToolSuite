package com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.StudentService;

@Controller
@RequestMapping("/myImage")
public class ImageController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");
		Blob ph = studentService.getPhotoById(id);
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
//	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
//	public void showImage(@RequestParam("id") Integer id,
//			HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
//		studentService.getPhotoById(id);
//		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//		response.getOutputStream().write(null);
//		response.getOutputStream().close();
//	}
}