package com.sts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
	@RequestMapping("/test")
	public String MyDemo()
	{
		return "Hello Trupti Arade";
	}
}