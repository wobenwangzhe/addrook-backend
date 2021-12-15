package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>addrook 个人通讯录系统后端项目启动类</b>
 * @author 王晗
 * @version 1.0.0
 */
@MapperScan("org.example.addrook.dao")
@SpringBootApplication(scanBasePackages = "org.example")
public class SystemApplicationStarter {
	public static void main(String[] args) {
		SpringApplication.run(SystemApplicationStarter.class,
				args);
	}
}
