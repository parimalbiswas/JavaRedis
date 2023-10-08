package com.parimal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig
{

//	@Value("127.0.0.1")
//	private static String redisHost;
//
//	@Value("6379")
//	private static int redisPort;
//
//	@Value("root")
//	private static String redisPassword;
//
//	@Bean
//	public JedisConnectionFactory connectionFactory()
//	{
//		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//		configuration.setHostName("localhost");
//		configuration.setPort(6379);
//
//		return new JedisConnectionFactory(configuration);
//	}
//
//	@Bean
//	public RedisConnectionFactory connectionFactory2()
//	{
//		LettuceConnectionFactory factory = new LettuceConnectionFactory();
//		factory.setHostName(redisHost);
//		factory.setPort(redisPort);
//		factory.setPassword(redisPassword);
//		return factory;
//	}
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate()
//	{
//
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(connectionFactory());
//		template.setKeySerializer(new StringRedisSerializer());
//		template.setHashKeySerializer(new StringRedisSerializer());
//		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
//		template.setValueSerializer(new JdkSerializationRedisSerializer());
//		template.setEnableTransactionSupport(true);
//		template.afterPropertiesSet();
//
//		return template;
//	}

}
