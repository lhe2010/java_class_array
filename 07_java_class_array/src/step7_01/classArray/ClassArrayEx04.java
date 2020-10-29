package step7_01.classArray;

import java.util.Scanner;

class User1{
	
	String id; 
	int money;
	
}


public class ClassArrayEx04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		final int MAX_NUM = 100;
		
		User1[] User1 = new User1[MAX_NUM];
		
		for (int i=0; i<MAX_NUM; i++) {
			User1[i] = new User1();
		}
		
		System.out.println(User1);
		System.out.println(User1[0]);
		System.out.println(User1[1]);
		
		User1[0].id = "qwer1234";
		User1[0].money = 1000;
		
		User1[1].id = "asdf1234";
		User1[1].money = 2000;
		
		int userCnt = 2;
		
		for (int i = 0; i < userCnt; i ++) {
			System.out.println(User1[i].id + " " + User1[i].money);
		}
		
		User1 temp = User1[1];
		temp.id = "zxcv1234";
		System.out.println("=====================================");
		
		for (int i = 0; i < userCnt; i ++) {
			System.out.println(User1[i].id + " " + User1[i].money);
		}

		scan.close();


	}

}
