package com.exactsix.mibaas.auth.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Roy Clarkson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

	private boolean status;
	private User data;

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
