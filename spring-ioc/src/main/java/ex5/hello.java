package ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hi")
public class hello {

	private String message;
	
	public hello()
	{
		
	}

	public hello(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Value("Hello Spring")
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

	
	
	
}
