// 2020-11-02 월 1-2교시 15:10-16:50 (1-4번)
package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

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
	
	StudentEx [] list = null;
	int stdCnt = 0;
	
	String filename = "ex13";
	File f = new File(filename);
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;
	
	void add_StudentEx(StudentEx st) {
		if(this.stdCnt == 0) {
			// 처음 생길때 - 바로 추가
			this.list = new StudentEx[1];
			this.list[0] = st;
		} else {
			// 처음이 아니면? - 복사후 추가 
			StudentEx[] nList = new StudentEx[stdCnt+1];
			for (int i = 0; i < this.stdCnt; i++) {
				nList[i] = this.list[i]; // 가능? 가능 ㅇㅇ 
//				nList[i].set_data(this.list[i].id, this.list[i].pw);
			}
			nList[this.stdCnt] = st;
			this.list = nList; // ******* 이거 안해주면 계속 nullError!!!!! *********
		}
		this.stdCnt++;
	}
	
	StudentEx remove_StudentEx (int index) {
		StudentEx e;
		// 한개일때 
		if( this.stdCnt == 1) {
			e = list[0];
			this.list = null;
		} else {
			// 여러개일때 
			e = list[index];
			for (int i = index; i < this.stdCnt-1; i++) {
				list[i] = list[i+1];
			}
		}
		this.stdCnt--;
		return e;
	}
	
	int check_id(StudentEx st) { // ID중복검사
		int check = -1;
		for (int i = 0; i < this.stdCnt; i++) {
			if(this.list[i].id.equals(st.id)) {
				check = i; 
			}
		}
		return check;	// 중복인 인덱스를, 중복아닌 경우 -1 리턴
	}
	
	void print_StudentEx() {
		for (int i = 0; i < this.stdCnt; i++) {
			this.list[i].print_data();			
		}
	}	
	
	String out_data() {		// [6] 불러오기 : 파일에 저장된 내용을 불러오기
		String data = "";
	
		try {
			f = new File(filename);
			if(f.exists()) {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				
				String str = "";
				str = br.readLine();
				while(str != null) {
					data += (str+"\n");
					str = br.readLine();
				}
				br.close();
				fr.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("data=" + data);
		
		String[] dataArr = data.split("\n");
		this.stdCnt = Integer.parseInt(dataArr[0]);
		this.list = new StudentEx[stdCnt];
		for (int i = 0; i < this.stdCnt; i++) {
			String[] temp = dataArr[i+1].split(",");
			this.list[i] = new StudentEx();
			this.list[i].set_data(temp[0], temp[1]);
		}

		this.print_StudentEx();
		return data;
	}
	
	void sort_data() {	// [3] 정렬하기 : 이름을 국어사전 순으로 정렬
		String[] strArr = new String[this.stdCnt];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = this.list[i].id;
		}
		for (int i = 0; i < strArr.length-1; i++) {
			for (int j = i+1; j < strArr.length; j++) {
				if(strArr[i].compareTo(strArr[j]) > 0) {
//					System.out.printf("i = %d, j = %d, compare = %d\n", i, j, strArr[i].compareTo(strArr[j]));
					String temp = strArr[i];
					strArr[i] = strArr[j];
					strArr[j] = temp;
				}
			}
		}
		System.out.println("[사전순 정렬 결과]");
		System.out.println(Arrays.toString(strArr));
	}
	
	void load_StudentEx (StudentEx [] temp , int count) {
		// [5] 저장하기 : 아래와 같은 형식으로 저장
		/*
		 * 			2				// 회원 수
		 *			qwer,1234		// id,pw	
		 *			abcd,1111		// id, pw
		 */
		String data = Integer.toString(count) + "\n";
		for (int i = 0; i < count; i++) {
			data += (temp[i].id + "," + temp[i].pw + "\n");
		}
		
		try {
			fw = new FileWriter(this.filename);
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);
		
	}
	
}

public class ClassArrayEx13_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager();
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				// [1] 가입하기 : ID 중복검사 구현
				StudentEx tmpSt = new StudentEx();
				while (true) {
					System.out.print("[1] 가입메뉴\n	아이디 : ");
					tmpSt.id = scan.next();
					if(manager.check_id(tmpSt) != -1) {
						System.out.println("아이디 중복!");
						continue;
					}
					System.out.print("	비밀번호 : ");
					tmpSt.set_data(tmpSt.id, scan.next());
					
					manager.add_StudentEx(tmpSt);
					System.out.printf("가입완료! %s 반갑습니다!\n", tmpSt.id); 
					break;
				}
			} else if (sel == 2) {
				// [2] 탈퇴하기 : ID를 입력받아 탈퇴
				StudentEx tmpSt = new StudentEx();
				while (true) {
					System.out.print("[2] 탈퇴메뉴\n	아이디 : ");
					tmpSt.id = scan.next();
					int check = manager.check_id(tmpSt); 
					if(check == -1) {
						System.out.println("아이디 없음!");
						continue;
					}
					System.out.print("	비밀번호 : ");
					if(!manager.list[check].pw.equals(scan.next())) {
						System.out.println("비밀번호 오류!"); 
						break;
					}					
					System.out.printf("탈퇴완료! %s 잘가요!\n", manager.remove_StudentEx(check).id); 
					break;
				}
			} else if (sel == 3) {
				if(manager.stdCnt > 0) {
					manager.sort_data();
				}
				
			} else if (sel == 4) {
				// [4] 출력하기 : 데이터들을 화면에 출력
				for (int i = 0; i < manager.stdCnt; i++) {
					manager.list[i].print_data();
				}
				
			} else if (sel == 5) {
				// [5] 저장하기 : 아래와 같은 형식으로 저장
				/* 			2				// 회원 수
				 *			qwer,1234		// id,pw	
				 *			abcd,1111		// id, pw */
				manager.load_StudentEx(manager.list, manager.stdCnt);
			} else if (sel == 6) {
				// [6] 불러오기 : 파일에 저장된 내용을 불러오기
				manager.out_data();
				
			} else if (sel == 7) { 
				// [7] 종료하기 : 반복문을 종료
				break; 
			}
			
		}
		scan.close();
	}

}
