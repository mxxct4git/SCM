package com.mxxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.mxxd.SCM.Dao")
public class ScmApplication {

	public static void main(String[] args) {
	    SpringApplication.run(ScmApplication.class, args);
	}
}
