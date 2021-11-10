package ex4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageProcessor implements ApplicationContextAware{
	
	
	
	public MessageProcessor() {
		System.out.println("Meaage Processor Constructor");
	}

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx= applicationContext;
		
	}
	
	public void process(String type,String to, String msg)
	{
		Message m = (Message) ctx.getBean(type);
		m.send(to, msg);
	}
	

}
