/**
 * 
 */
package com.varma.main.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Varma
 *
 */
@Component
public class ErrorDetails {
	
	private int errorCode;
	private String errorDescription;
	private Date created;
	
	/**
	 * 
	 */
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param errorCode
	 * @param errorDescription
	 * @param created
	 */
	public ErrorDetails(int errorCode, String errorDescription, Date created) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.created = created;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "ErrorDetails [errorCode=" + errorCode + ", "
				+ (errorDescription != null ? "errorDescription=" + errorDescription + ", " : "")
				+ (created != null ? "created=" + created : "") + "]";
	}
	
	

}
