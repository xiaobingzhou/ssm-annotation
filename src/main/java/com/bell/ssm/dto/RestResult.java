package com.bell.ssm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RestResult {
	private Integer code;
	private String msg;
	@JsonInclude(value = Include.NON_NULL)
	private Object data;
	
	public static RestResult ok(Object data) {
		return new RestResult(0, "ok", data);
	}
	public static RestResult error(Throwable e) {
		return new RestResult(-99, e.getLocalizedMessage(), null);
	}
	public static RestResult codeMsg(CodeMsg codeMsg) {
		return new RestResult(codeMsg.getCode(), codeMsg.getMsg(), null);
	}
	
	public RestResult() {
		super();
	}
	public RestResult(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
