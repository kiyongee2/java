package bankaccount;

import java.util.ArrayList;
import java.util.Scanner;

public class AppMain2 {
	private static ArrayList<Account> accountList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌 생성 |2.계좌 목록 |3.입금 |4.출금 |5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");
			
			int selNum = sc.nextInt();
			if(selNum==1) {
				createAccount();
			}else if(selNum==2) {
				accountList();
			}else if(selNum==3) {
				deposit();
			}else if(selNum==4) {
				withdraw();
			}else {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		sc.nextInt();
	}
	
	private static void createAccount() {
		System.out.println("------------");
		System.out.println("계좌 생성");
		System.out.println("------------");
		
		System.out.print("계좌번호 : ");
		String accountNum = sc.next();
		
		System.out.print("계좌주 : ");
		String owner = sc.next();
		
		System.out.print("초기 입금액 : ");
		int balance = sc.nextInt();
		
		Account newAccount = new Account(accountNum, owner, balance);
		
		accountList.add(newAccount);  //생성된 계좌를 리스트에 저장
		System.out.println("처리 결과 : 계좌가 생성되었습니다.");
	}
	
	private static void accountList() {
		System.out.println("------------");
		System.out.println("계좌 목록");
		System.out.println("------------");
		for(int i=0; i<accountList.size(); i++) {
			Account account = accountList.get(i);  //저장된 계좌를 출력용 계좌에 저장.
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
		System.out.println("------------");
		System.out.println("입금");
		System.out.println("------------");
		
		System.out.print("계좌 번호 : ");
		String accountNum = sc.next();
		
		System.out.print("입금액 : ");
		int money = sc.nextInt();
		try {
			Account account = findAccount(accountNum);
			account.setBalance(account.getBalance() + money);
			System.out.println("처리 결과 : 입금을 성공하였습니다.");
		}catch(Exception e) {
			System.out.println("처리 결과 : 계좌가 없습니다."); 
			//계좌가 없는 경우 - nullPointer Excetion 처리
		}
	}
	
	private static void withdraw() {
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		
		System.out.print("계좌 번호 : ");
		String accountNum = sc.next();
		
		System.out.print("출금액 : ");
		int money = sc.nextInt();
		
		try {
			Account account = findAccount(accountNum);
			while(true) {
				if(money > account.getBalance()) {
					System.out.println("잔액이 부족합니다. 다시 출금해 주세요");
					System.out.print("출금액 : ");
					money = sc.nextInt();
				}else {
					account.setBalance(account.getBalance() - money);
					System.out.println("처리 결과 : 출금을 성공하였습니다.");
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("처리 결과 : 계좌가 없습니다."); 
			//계좌가 없는 경우 - nullPointer Excetion 처리
		}
	}
	
	private static Account findAccount(String accountNum) {
		Account account = null;
		for(int i=0; i<accountList.size(); i++) {
			String dbAno = accountList.get(i).getAccountNum(); //리스트의 계좌번호를 가져옴
			if(dbAno.equals(accountNum)) { //저장된 계좌번호가 찾는 계좌번호와 같다면
				account = accountList.get(i);  //저장된 계좌를 가져옴
				break;
			}
		}
		return account;
	}
}
