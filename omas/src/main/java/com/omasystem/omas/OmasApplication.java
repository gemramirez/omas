package com.omasystem.omas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.omasystem.omas.Dao")
public class OmasApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmasApplication.class, args);
	}

}
