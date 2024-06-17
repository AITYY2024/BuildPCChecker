package com.buildpcchecker.buildpcchecker;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import com.buildpcchecker.buildpcchecker.preset.PresetDao;
import com.buildpcchecker.buildpcchecker.preset.PresetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BuildpccheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildpccheckerApplication.class, args);
	}

}
