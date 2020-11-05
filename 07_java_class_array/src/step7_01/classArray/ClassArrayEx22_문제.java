// 2020-11-04 수 3교시 17:05-17:48
// 2020-11-05 목 1교시 15:06-15:21 (로드 완성. filename에 txt까지 넣어야함)
// 2020-11-05 목 1교시 15:21-15:53 (저장 메소드 수정. 정렬 완성)
package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	// 저장메뉴. 메인이랑 메소드 기능을 분리할때 어디까지 분리해야 하는가...**** 
	// -> 가독성이 중요! 아직은 구조 노노
	int outData(String filename) { 
		String data = "";
		for (StudentVO s : vec) {
			data += (s.id + "," + s.pw + "\n");
		}
		
		try {
			
			f = new File(filename);
			fw = new FileWriter(f);
			
			fw.write(data);
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}			
		
		return 1;
	}
	
	int loadData(String filename) {
		f = new File(filename);
		try {
			if(f.exists()) {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String data = "";
			String[] temp = new String[2];
			
			// 로드
			data = br.readLine(); 
			while(data != null) {
				temp = data.split(",");
//				System.out.printf("temp[0]= %s, temp[1]=%s\n",temp[0], temp[1]);
				this.vec.add(new StudentVO(temp[0], temp[1]));
				data = br.readLine();
			}
			br.close();
			fr.close();
			} else
				return -1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	void sortData() {
		for (int i = 0; i < vec.size(); i++) {
			for (int j = i+1; j < vec.size(); j++) {
				if(vec.get(i).id.compareTo(vec.get(j).id) > 0) { // sTemp가 앞이 아니면? 순서 교체
//					System.out.printf("if안에 들어옴! i=%d, j=%d\n", i, j);
					StudentVO temp = vec.get(i);
					vec.set(i, vec.get(j));
					vec.set(j, temp);
				} 
			}
		}
	}
}

public class ClassArrayEx22_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		StudentManager manager = new StudentManager();		
		String myId, myPw;
		
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
				manager.sortData();
			} else if (sel == 4) { // 출력메뉴
				if(manager.vec.size() > 0) {
					System.out.println("[전체회원리스트 출력]");
					manager.printAll();
				}
			} else if (sel == 5) {		// 저장메뉴
				System.out.println("[저장메뉴]");
				if(manager.outData("ex22.txt") == -1) 
					System.out.println("저장중 오류!");
				else 
					System.out.println("저장 완료");
					
			} else if (sel == 6) {		// 로드메뉴
				System.out.println("[로드메뉴]");
				if(manager.loadData("ex22.txt") == -1) 
					System.out.println("로드중 오류!");
				else 
					System.out.println("로드 완료");
				
			} else if (sel == 7) {		// 종료
				System.out.println("[프로그램종료]");
				break;
			}
		}
	}
}
