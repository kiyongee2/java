package classpart;

class Hello{
	public void sayHello() {
		System.out.println("Hello~ ");
	}
}

public class HelloTest{

	public static void main(String[] args) {
		Hello hello = new Hello();  //Hello 객체 생성
		
		hello.sayHello();  //sayHello() 호출
	}
}
