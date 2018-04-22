package com.mustafazorbaz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author Mustafa
 * Ana controller ile ilk açılış sayfasını belirttik.
 */
@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("home");
	}
	 
}
