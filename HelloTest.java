package hello;

class Hello{
	public void sayHello() { //��ȯ���� void�� �޼���
		System.out.println("Hello~ Java");
	}
	
	public void sayHello(String name) { //�Ű������� �ִ� �޼���
		System.out.println("Hello~ " + name);
	}
}

public class HelloTest {

	public static void main(String[] args) {
		Hello hello = new Hello();
		
		hello.sayHello();
		
		hello.sayHello("�ڸ���");
		hello.sayHello("Biden");
	}
}
