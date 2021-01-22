package hello;

class Hello{
	public void sayHello() { //반환형이 void인 메서드
		System.out.println("Hello~ Java");
	}
	
	public void sayHello(String name) { //매개변수가 있는 메서드
		System.out.println("Hello~ " + name);
	}
}

public class HelloTest {

	public static void main(String[] args) {
		Hello hello = new Hello();
		
		hello.sayHello();
		
		hello.sayHello("박마늘");
		hello.sayHello("Biden");
	}
}
