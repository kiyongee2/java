package exchange;

import java.util.Scanner;

public class ExchangeRate {
	private static float USD = 1099.48F;  //환율 상수로 선언
	private static float JPY = 10.64F;
	private static float EURO = 1347.69F;
	private static float CNY = 168.19F;
	
	public static void main(String[] args) {
		// 환율 변환기 만들기
		Scanner sc = new Scanner(System.in);
		float exchange = 0;   //환전 금액
		boolean run = true;   //실행, 종료 넣을 변수
		
		System.out.println("-----------------------------------------------");
		System.out.println("1.달러 | 2.엔 |3.유로 |4.위안 |5.종료");
		System.out.println("-----------------------------------------------");
		 
		try {   //오류가 날 수 있는 부분
			while(run) {
				System.out.print("원화 입력> ");
				int won = sc.nextInt();
				System.out.print("선택 > ");
				int selNum = sc.nextInt();
				
				if(selNum==1) {
					exchange = won / USD;    //환전금액 = 원화 / 달러비율
					System.out.printf("환전 금액 : %.2f달러\n", exchange);
				}else if(selNum==2) {
					exchange = won / JPY;
					System.out.printf("환전 금액 : %.2f엔\n", exchange);
				}else if(selNum==3) {
					exchange = won / EURO;
					System.out.printf("환전 금액 : %.2f유로\n", exchange);
				}else if(selNum==4) {
					exchange = won / CNY; 
					System.out.printf("환전 금액 : %.2f위안\n", exchange);
				}else if(selNum==5) {
					run = false;
				}
			}
			System.out.println("프로그램 종료!!");
			sc.close();
		}catch(Exception e) {
			System.out.println(e);    //예외 처리 출력
		}
	}
}
