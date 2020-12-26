package exchange;

import java.util.Scanner;

public class ExchangeRate {
	private static float USD = 1099.48F;  //ȯ�� ����� ����
	private static float JPY = 10.64F;
	private static float EURO = 1347.69F;
	private static float CNY = 168.19F;
	
	public static void main(String[] args) {
		// ȯ�� ��ȯ�� �����
		Scanner sc = new Scanner(System.in);
		float exchange = 0;   //ȯ�� �ݾ�
		boolean run = true;   //����, ���� ���� ����
		
		System.out.println("-----------------------------------------------");
		System.out.println("1.�޷� | 2.�� |3.���� |4.���� |5.����");
		System.out.println("-----------------------------------------------");
		 
		try {   //������ �� �� �ִ� �κ�
			while(run) {
				System.out.print("��ȭ �Է�> ");
				int won = sc.nextInt();
				System.out.print("���� > ");
				int selNum = sc.nextInt();
				
				if(selNum==1) {
					exchange = won / USD;    //ȯ���ݾ� = ��ȭ / �޷�����
					System.out.printf("ȯ�� �ݾ� : %.2f�޷�\n", exchange);
				}else if(selNum==2) {
					exchange = won / JPY;
					System.out.printf("ȯ�� �ݾ� : %.2f��\n", exchange);
				}else if(selNum==3) {
					exchange = won / EURO;
					System.out.printf("ȯ�� �ݾ� : %.2f����\n", exchange);
				}else if(selNum==4) {
					exchange = won / CNY; 
					System.out.printf("ȯ�� �ݾ� : %.2f����\n", exchange);
				}else if(selNum==5) {
					run = false;
				}
			}
			System.out.println("���α׷� ����!!");
			sc.close();
		}catch(Exception e) {
			System.out.println(e);    //���� ó�� ���
		}
	}
}
