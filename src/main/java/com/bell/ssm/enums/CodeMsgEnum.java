package com.bell.ssm.enums;

import com.bell.ssm.dto.CodeMsg;

public enum CodeMsgEnum implements CodeMsg {
	OK(0,"ok"),
	NO_LOGIN(-1,"No Login"),
	
	;
	private int code;
	private String msg;
	private CodeMsgEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getMsg() {
		return this.msg;
	}

}
