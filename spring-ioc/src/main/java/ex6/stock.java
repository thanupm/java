package ex6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stk")
@Scope("singleton")

public class stock {
	public stock() {
		System.out.println("Stock Constructor");
	}
	private static stock stk;

	
	
	public static stock get()
	{
		if(stk == null)
			stk = new stock();
		
		return stk;
	}
}
