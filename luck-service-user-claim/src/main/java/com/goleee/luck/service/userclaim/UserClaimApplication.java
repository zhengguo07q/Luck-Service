package com.goleee.luck.service.userclaim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import feign.RequestInterceptor;

/**
 * 用户要求设置许可
 * 	1要求不需要创建， 只需要设置， 每个用户都有一个
 *	2要求可以更新
 *	3部分用户VIP级别不够，只能更新最小的要求
 * 
 * @author zg
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Client
@EnableFeignClients
public class UserClaimApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(UserClaimApplication.class, args);
	}

	/**
	 * 设置授权类型，客户端授权
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "security.oauth2.client")
	public ClientCredentialsResourceDetails clientCredentialsResourceDetails()
	{
		return new ClientCredentialsResourceDetails();
	}

	/**
	 * 在feign上下文中加入授权信息
	 * 
	 * @return
	 */
	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor()
	{
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
	}

	@Bean
	public OAuth2RestTemplate clientCredentialsRestTemplate()
	{
		return new OAuth2RestTemplate(clientCredentialsResourceDetails());
	}

}