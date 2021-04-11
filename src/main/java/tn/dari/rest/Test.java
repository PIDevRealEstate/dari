package tn.dari.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/go")
@RestController
public class Test {
	
	@GetMapping("/ok")
	public String ok () {
		return ("ok");
	}
}
