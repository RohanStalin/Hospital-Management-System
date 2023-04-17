package boot.dto;

import lombok.Data;

@Data
public class ResponseMessage {
	  private String message;
	  
	  private String role;

	  public ResponseMessage(String message,String role) {
	    this.message = message;
	    this.role = role;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
	}
