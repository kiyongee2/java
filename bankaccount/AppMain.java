package bankaccount;

import java.util.Scanner;

public class AppMain {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("=========================================");
			System.out.println("1.���� ���� |2.���� ��� |3.�Ա� |4.��� |5.����");
			System.out.println("=========================================");
			System.out.print("����> ");
			
			int selNum = sc.nextInt();
			if(selNum==1) {
				createAccount();  //���� ����
			}else if(selNum==2) {
				accountList();    //���� ���
			}else if(selNum==3) {
				deposit();        //�Ա�
			}else if(selNum==4) {
				withdraw();       //���
			}else {
				run = false;
			}
		}
		System.out.println("���α׷� ����");
		sc.nextInt();
	}
	
	private static void createAccount() {
		System.out.println("============");
		System.out.println("���� ����");
		System.out.println("============");
		
		System.out.print("���¹�ȣ : ");
		String accountNum = sc.next();
		
		System.out.print("������ : ");
		String owner = sc.next();
		
		System.out.print("�ʱ� �Աݾ� : ");
		int balance = sc.nextInt();
		
		Account newAccount = new Account(accountNum, owner, balance);
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i]==null) {  //accountArray[i]�� ����ִ� ����(�߰��� ������ ���� ã��)
				accountArray[i] = newAccount;
				System.out.println("ó�� ��� : ���°� �����Ǿ����ϴ�.");
				break;
			}	
		}
	}
	
	private static void accountList() {
		System.out.println("============");
		System.out.println("���� ���");
		System.out.println("============");
		
		for(int i=0; i<accountArray.length; i++) {
			Account account = accountArray[i];  //����� ���¸� ��¿� ���¿� ����.
			if(account != null) {
				System.out.print(account.getAccountNum());
				System.out.print("     ");
				System.out.print(account.getOwner());
				System.out.print("     ");
				System.out.println(account.getBalance());
			}
		}
	}
	
	private static void deposit() {
		System.out.println("============");
		System.out.println("�Ա�");
		System.out.println("============");
		
		System.out.print("���� ��ȣ : ");
		String accountNum = sc.next();
		
		System.out.print("�Աݾ� : ");
		int money = sc.nextInt();
		
		try {
			Account account = findAccount(accountNum);
			account.setBalance(account.getBalance() + money);
			System.out.println("ó�� ��� : �Ա��� �����Ͽ����ϴ�.");
		}catch(NullPointerException e) {  //Exception e�� �ص� ��.
			System.out.println("ó�� ��� : ���°� �����ϴ�.");
		}
	}
	
	private static void withdraw() {
		System.out.println("============");
		System.out.println("���");
		System.out.println("============");
		
		System.out.print("���� ��ȣ : ");
		String accountNum = sc.next();
		
		System.out.print("��ݾ� : ");
		int money = sc.nextInt();
		
		try {
			Account account = findAccount(accountNum);
			while(true) {
				if(money > account.getBalance()) {
					System.out.println("ó�� ��� : �ܾ��� �����մϴ�. �ٽ� ����� �ּ���");
					System.out.print("��ݾ� : ");
					money = sc.nextInt();
				}else {
					account.setBalance(account.getBalance() - money);
					System.out.println("ó�� ��� : ����� �����Ͽ����ϴ�.");
					break;
				}
			}
			
		}catch(Exception e) {//���°� ���� ��� - nullPointer Excetion ó��
			System.out.println("ó�� ��� : ���°� �����ϴ�."); 
		}
	}
	
	private static Account findAccount(String accountNum) {
		Account account = null;
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {
				String dbAno = accountArray[i].getAccountNum();
				if(dbAno.equals(accountNum)) { //����� ���¹�ȣ�� ã�� ���¹�ȣ�� ���ٸ�
					account = accountArray[i];  //����� ���¸� ������
					break;
				}
			}
		}
		return account;    //����� ���¸� ��ȯ
	}
}
