package com.crs.app.hotel.dto;

public class SuccessResponse<T> extends BaseRestApiResponse{
	
	private T response;
	
	public SuccessResponse(T response) {
		super();
		this.response=response;
	}
	

}
