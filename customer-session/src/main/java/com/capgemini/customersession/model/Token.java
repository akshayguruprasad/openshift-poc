package com.capgemini.customersession.model;

import java.io.Serializable;

public class Token implements Serializable {
	private static final long serialVersionUID = 1L;
	private String jwtToken;
	private String customerId;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Token [jwtToken=" + jwtToken + ", customerId=" + customerId + "]";
	}

}
