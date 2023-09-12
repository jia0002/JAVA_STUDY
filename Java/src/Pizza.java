class Circle {
	protected int radius;
	public Circle(int r) {
		radius=r;
	}
}

public class Pizza extends Circle{
	String name;
	
	public Pizza(String n, int r) {
		super(r);
		this.name = n;		
	}
	
	public void print() {
		System.out.println("피자 종류: "+this.name+", 피자 반지름: "+super.radius);
	}
	
	public static void main(String args[]) {
		Pizza obj = new Pizza("Pepperoni", 20);
		obj.print();
		
	}

}