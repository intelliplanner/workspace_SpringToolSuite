package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	private static String filePath = "D:\\Working\\workspace_SpringToolSuite\\SpringMVC\\src\\main\\webapp\\resources\\images\\";

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listemployees(Model model) throws Exception {
		model.addAttribute("student", new Student());
		return "addStudent";
	}

	@ModelAttribute
	public void addingCommonObject(Model m) {
		m.addAttribute("headerMsg", "Student Details");
	}

	@RequestMapping(value = "/deleteStudent/{id}")
	public String delete(@PathVariable int id) {
		studentService.removeStudent(id);
		return "redirect:/student/show";
	}

	@RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET)
	public ModelAndView findById(@PathVariable int id) {
		ModelAndView m = new ModelAndView("addStudent");
		Student studentData = studentService.getStudentById(id);
		m.addObject("student", studentData);
		return m;
	}

	@RequestMapping(value = "/show")
	public String getEmployees(Model model) throws Exception {
		List<Student> studentList = studentService.listStudents();
		model.addAttribute("list", studentList);
		return "showStudents";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student,
			@RequestParam("file") MultipartFile file, BindingResult br) throws Exception {
		String name = "";
		if (br.hasErrors()) {
			return "addStudent";
		}

		if (!file.isEmpty()) {
			try {
				byte[] imageBytes = file.getBytes();
				// FileInputStream inputStream = new FileInputStream(file);
				name = file.getOriginalFilename();
				System.out.println("resources:" + filePath);
				String fullPath = filePath + name;
				System.out.println(fullPath);

				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.flush();
				stream.close();
				student.setImage_1(imageBytes);
				student.setImage1_name(name);
				student.setImage_2(new SerialBlob(imageBytes));
				System.out.println("You successfully uploaded file=" + name);
			} catch (Exception e) {
				throw new Exception("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			throw new Exception("You failed to upload " + name + " because the file was empty.");
		}

		if (student.getId() > 0) {
			studentService.updateStudent(student);
		} else {
			studentService.addStudent(student);
		}

		return "redirect:/student/show";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {

		ServletContext context = session.getServletContext();
		String path = context.getRealPath(filePath);
		String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + "\\" + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return new ModelAndView("uploadSingleFile", "filesuccess", "File successfully saved!");
	}
//	@RequestMapping(value="/save", method = RequestMethod.POST)
//	public String insert(@ModelAttribute Model m) {

//	@ModelAttribute("student")
//	   public Student createStudentModel() {	
//	      return new Student();
//	   }

//	
//	@RequestMapping("/")
//	public String showForm(Model m) {
//		m.addAttribute("command", new Student());
//		return "addStudent";
//	}
//	@RequestMapping("/")
//	 public ModelAndView showForm() {
//		new ModelAndView("addStudent", "student", new Student());
//	      return new ModelAndView("addStudent", "student", new Student());
//	   }

//	@RequestMapping(value="/show")
//	public String findAll(Model m) throws Exception{
//		List<Student> studentList = studentService.listStudents();
//		m.addAttribute("list", studentList);
//		return "showStudents";  
//	}
//	

}
