package com.goleee.luck.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 注册服务器
 * @author zg
 *
 */

@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(RegistryApplication.class, args);
	}
}
