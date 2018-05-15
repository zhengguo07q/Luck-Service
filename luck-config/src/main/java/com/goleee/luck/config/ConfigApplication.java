package com.goleee.luck.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置服务器
 * 
 * @author zg
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ConfigApplication.class, args);
	}
}
