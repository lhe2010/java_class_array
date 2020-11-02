package step7_01.classArray;

import java.util.Scanner;

/*
class StudentEx{
	
	String id = "";
	String pw = "";
	
	void set_data(String id , String  pw) {
		this.id = id; 
		this.pw = pw;
	}
	
	
	void print_data() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
	}
	
}

class Manager{
	
	Student [] list = null;
	int stdCnt = 0;
	
	void add_StudentEx(StudentEx st) {}
	
	StudentEx remove_StudentEx (int index) {}
	
	int check_id(StudentEx st) {}
	
	void print_StudentEx() {}	
	
	String out_data() {}
	
	void sort_data() {}
	
	void load_StudentEx (StudentEx [] temp , int count) {}
	
}
*/

public class ClassArrayEx13_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Manager manager = new Manager();
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			/*
			 * [1] 가입하기 : ID 중복검사 구현
			 * [2] 탈퇴하기 : ID를 입력받아 탈퇴
			 * [3] 정렬하기 : 이름을 국어사전 순으로 정렬
			 * [4] 출력하기 : 데이터들을 화면에 출력
			 * [5] 저장하기 : 아래와 같은 형식으로 저장
			 * [6] 불러오기 : 파일에 저장된 내용을 불러오기
			 * [7] 종료하기 : 반복문을 종료
			 * 
			 * 			예) 
			 * 			2				// 회원 수
			 *			qwer,1234		// id,pw	
			 *			abcd,1111		// id, pw
			 */
			
			if		(sel == 1) {}
			else if (sel == 2) {}
			else if (sel == 3) {}
			else if (sel == 4) {}
			else if (sel == 5) {}
			else if (sel == 6) {}
			else if (sel == 7) { 
				break; 
			}
			
		}

	}

}
