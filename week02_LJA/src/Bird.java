interface Animal{
	void walk();
	void fly();
	void sing();
}

public class Bird implements Animal{
	public void walk() {
		System.out.println("걸을 수 있음");
	}
	
	public void fly() {
		System.out.println("날을 수 있음");
	}
	public void sing() {
		System.out.println("노래 부를 수 있음");
	}

	public static void main(String[] args) {
		Bird bird = new Bird();
		
		bird.walk();
		bird.fly();
		bird.sing();
	}
}