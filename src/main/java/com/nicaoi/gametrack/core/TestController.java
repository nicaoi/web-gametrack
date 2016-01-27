package com.nicaoi.gametrack.core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: ksutton
 * Date Created: 20/01/2016.
 */
@Controller
public class TestController {

	@RequestMapping("/test")
	public String test(Model model) {
		String name = "name";
		model.addAttribute("name", name);
		return "test";
	}
}
