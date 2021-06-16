package com.crs.app.hotel.dto;

public class SuccessResponse<T> extends BaseRestApiResponse{
	
	private T response;
	
	public SuccessResponse(T response) {
		super();
		this.response=response;
	}
	public SuccessResponse(String message,T response) {
		super(message,true);
		this.response=response;
	}

	public Object getResponse() {
		return response;
	}

	public SuccessResponse(String message, boolean success) {
		super(message, success);
		// TODO Auto-generated constructor stub
	}
	public SuccessResponse(String message,boolean success,T response) {
		super(message,success);
		this.response=response;
	}
	

}
