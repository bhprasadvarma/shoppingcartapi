/**
 * 
 */
package com.varma.main.service;

import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.varma.main.entity.ErrorDetails;

/**
 * @author Varma
 *
 */
@Component
@Service
@Provider
public class ErrorResponseService {
	ErrorDetails errorDetails;
	
	public Response getBadRequestErrorRespone(int errorCode,String errorDescription) {
		 errorDetails = new ErrorDetails(errorCode,errorDescription, new Date());
		 return Response.status(Status.BAD_REQUEST)
					.entity(errorDetails)
					.build();		 
	}

	public Response getInternalServerErrorRespone(int errorCode,String errorDescription) {
		 errorDetails = new ErrorDetails(errorCode,errorDescription, new Date());
		 return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(errorDetails)
					.build();		 
	}
	
	
	public Response getFoundErrorRespone(int errorCode,String errorDescription) {
		 errorDetails = new ErrorDetails(errorCode,errorDescription, new Date());
		 return Response.status(Status.FOUND)
					.entity(errorDetails)
					.build();		 
	}
	
	public Response getNotFoundErrorRespone(int errorCode,String errorDescription) {
		 errorDetails = new ErrorDetails(errorCode,errorDescription, new Date());
		 return Response.status(Status.NOT_FOUND)
					.entity(errorDetails)
					.build();		 
	}
}
