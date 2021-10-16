package com.chat.bean;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.WebChatService;

@Controller
@RequestMapping("/")
public class WebChatController {

	@Autowired
	WebChatService webChatService;

	
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String viewMsg(Model m) {
		//ModelAndView m = new ModelAndView();
		m.addAttribute("list", webChatService.getMsg());
//		m.setViewName("index");
		return "ViewChat";
	}
	
	@RequestMapping(value = "/add")
	public String showForm(Model m) {
		m.addAttribute("chat", new WebChat());
		return "AddMsg";
	}

	@ModelAttribute
	public void addHeader(Model m) {
		m.addAttribute("headerMsg", "Chat Application");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addMsg(@Valid  @ModelAttribute("chat") WebChat webChat,BindingResult br) {
		if(br.hasErrors()) {
			return "AddMsg";
		}
		webChatService.insert(webChat);
		return "redirect:add";
	}

	
	@RequestMapping(value="/auto",method = RequestMethod.GET)
	public String autoReloadMsg(Model m) {
		//ModelAndView m = new ModelAndView();
		m.addAttribute("list", webChatService.getMsg());
//		m.setViewName("index");
		return "ViewChat";
	}
	

}
