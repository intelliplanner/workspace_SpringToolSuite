package com.ipssi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BootController  {
	

	@RequestMapping("/")
	public String index() {return "index";}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView show(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userData");
		mv.addObject("user", user);
		return mv;
	}
	@RequestMapping("/hello")
	public String print() {
		System.out.print("hello polo");
		return "Hello";
	}
}
