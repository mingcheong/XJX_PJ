package com.safetys.framework.utils;

/**
 * 操作结果集
 * 
 * @author Stone
 */
public class OperateResult {

	// 状态
	private boolean state;
	// 消息
	private String message;
	// 返回结果
	private Object result;

	public OperateResult() {
		super();
	}

	public OperateResult(boolean state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public OperateResult(boolean state, String message, Object result) {
		super();
		this.state = state;
		this.message = message;
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
