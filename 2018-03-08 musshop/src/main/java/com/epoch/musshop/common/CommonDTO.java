package com.epoch.musshop.common;

import java.io.Serializable;

public class CommonDTO implements Serializable {
    private String success;
    private Object data;

    public CommonDTO() {
    }

	public CommonDTO(String success, Object data) {
		super();
		this.success = success;
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

    
}
