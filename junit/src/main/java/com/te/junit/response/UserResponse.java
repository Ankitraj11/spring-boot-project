package com.te.junit.response;

public class UserResponse {

	    private String message;
	    private boolean error;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public boolean isError() {
			return error;
		}
		public void setError(boolean error) {
			this.error = error;
		}
		public UserResponse(String message, boolean error) {
			super();
			this.message = message;
			this.error = error;
		}
	   
	    
	
}
