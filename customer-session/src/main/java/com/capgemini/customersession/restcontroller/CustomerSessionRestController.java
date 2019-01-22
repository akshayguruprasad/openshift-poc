package com.capgemini.customersession.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customersession.model.Token;

import redis.clients.jedis.Jedis;

@RestController
public class CustomerSessionRestController {
	private static final String CUSTOMER_GROUP = "customers";
	@Autowired
	private Jedis jedisClient;

	@GetMapping("/token")
	public String getToken(HttpServletRequest request) {
		List<String> tokenValue = null;
		String key = null;
		try {
			key = request.getHeader("key");

			tokenValue = jedisClient.hmget(CUSTOMER_GROUP, key);

		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
		return tokenValue.get(0);

	}

	@PostMapping("/token")
	public boolean saveToken(@RequestBody Token token) {
		try {
			jedisClient.hset(CUSTOMER_GROUP, token.getCustomerId(), token.getJwtToken());

		} catch (RuntimeException e) {
			return false;
		}
		return true;

	}

}
