package com.buildpcchecker.buildpcchecker;

import com.buildpcchecker.buildpcchecker.compatible.CompatibleDao;
import com.buildpcchecker.buildpcchecker.compatible.IcompatibleDao;
import com.buildpcchecker.buildpcchecker.compatible.IcompatibleService;
import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BuildpccheckerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BuildpccheckerApplication.class, args);



	}

}
