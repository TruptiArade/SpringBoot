package com.sts.ImageUpload;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageUploadApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ImageUploadApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper()

	{
		return new ModelMapper();
	}

}
