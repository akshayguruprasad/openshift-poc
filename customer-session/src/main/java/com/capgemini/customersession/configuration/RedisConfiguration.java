package com.capgemini.customersession.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfiguration {

	@Bean
	public Jedis getJedisClient() {

		Jedis jedis = new Jedis("localhost", 6379);
		return jedis;
	}
}
