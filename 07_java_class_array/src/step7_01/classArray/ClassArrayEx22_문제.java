// 2020-11-04 수 3교시 17:05-17:48
package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

class StudentVO {
	String id;
	String pw;
	
	public StudentVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
}

class StudentManager {
	
	String myId, myPw, filename;
	File f = null;
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;
	
	Vector<StudentVO> vec = new Vector<StudentVO>();
	
	int idCheck (String id) {
		for (int i = 0; i < vec.size(); i++) {
			if(vec.get(i).id.equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	void printAll () {
		for (StudentVO s : this.vec) 
			System.out.printf("ID : %s, PW : %s\n", s.id, s.pw);
	}
	
	String outData() {
		String data = "";
		for (StudentVO s : vec) {
			data += (s.id + "," + s.pw + "\n");
		}
		return data;
	}
	
	int loadData(String filename) {
		f = new File(filename);
		try {
			if(!f.exists()) {
				return -1;
			}
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String temp = "";
			String data = "";
			
			br.close();
			fr.close();
			return 1;
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

public class ClassArrayEx22_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		StudentManager manager = new StudentManager();
		
		String myId, myPw, filename;
		File f = null;
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		while (true) {
			
			System.out.println("\n1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				while(true) {
					System.out.println("[가입메뉴]");
					System.out.print("...ID : ");
					myId = scan.next();
					if(manager.idCheck(myId) != -1) {
						System.out.println("...!!중복ID");
						continue;
					} else 
						break;
				}
				// 중복아니면
				System.out.print("...PW : ");
				myPw = scan.next();
				
				manager.vec.add(new StudentVO(myId, myPw));
				System.out.printf("%s님 환영합니다!\n", myId);
				
			} else if (sel == 2) {
				System.out.println("[탈퇴메뉴]");
				while(true) {
					System.out.print("...ID : ");
					myId = scan.next();
					int outIdx = manager.idCheck(myId);
					if( outIdx == -1) {
						System.out.println("...!!존재하지 않는 ID");
						continue;
					}
					System.out.print("...PW : ");
					myPw = scan.next();
					if(!manager.vec.get(outIdx).pw.equals(myPw)) {
						System.out.println("...!!올바르지 않은 PW");
						continue;
					} else {
						System.out.printf("%s님 안녕히 가세요.\n", manager.vec.get(outIdx).id);
						manager.vec.remove(outIdx);
						break;
					}
				}
			} else if (sel == 3) { // 정렬메뉴
				System.out.println("[정렬]");
				
			} else if (sel == 4) { // 출력메뉴
				if(manager.vec.size() > 0) {
					System.out.println("[전체회원리스트 출력]");
					manager.printAll();
				}
			} else if (sel == 5) {		// 저장메뉴
				System.out.println("[저장메뉴]");
				
				try {
					f = new File("ex22");
					fw = new FileWriter(f);
					
					fw.write(manager.outData());
					
					fw.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			} else if (sel == 6) {		// 로드메뉴
				System.out.println("[로드메뉴]");
				
			} else if (sel == 7) {		// 종료
				System.out.println("[프로그램종료]");
				break;
			}
			
		}



	}

}
