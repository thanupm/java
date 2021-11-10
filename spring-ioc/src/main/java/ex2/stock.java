package ex2;

public class stock {
	public stock() {
		System.out.println("Stock Constructor");
	}
	private static stock stk;

	public stock get()
	{
		if(stk == null)
			stk = new stock();
		
		return stk;
	}
}
