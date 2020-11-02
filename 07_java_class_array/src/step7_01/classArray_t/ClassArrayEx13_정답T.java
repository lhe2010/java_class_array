package step7_01.classArray_t;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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



class Manager {
	
	StudentEx[] list = null;
	int stdCnt = 0;
	
	void add_StudentEx(StudentEx st) {
		
		if (stdCnt == 0) {
			list = new StudentEx[1];
		}
		else if (stdCnt > 0) {
			StudentEx[] temp = list;
			list = new StudentEx[stdCnt + 1];
			for (int i = 0; i < stdCnt; i++) {
				list[i] = temp[i];
			}
			temp = null;
		}
		list[stdCnt] = st;
		stdCnt++;
		
	}
	
	
	
	StudentEx remove_StudentEx (int index) {
		
		StudentEx del_st = list[index];
		if (stdCnt == 1) {
			list = null;
		}
		else if (stdCnt > 1) {
			StudentEx [] temp = list;
			list = new StudentEx[stdCnt -1];
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			for (int i = index; i < stdCnt -1; i++) {
				list[i] = temp[i + 1];
			}
			temp = null;
		}
		stdCnt--;	
		return del_st;
		
	}
	
	
	
	int check_id(StudentEx st) {
		
		int check = -1;
		for (int i = 0; i < stdCnt; i++) {
			if (list[i].id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
		
	}
	
	
	
	void print_StudentEx() {
		
		for (int i = 0; i < stdCnt ;i++) {
			list[i].print_data();
		}
		
	}	
	
	
	
	String out_data() {
		
		String data = "";
		if (stdCnt == 0){
			return data;
		}
		data += stdCnt;
		data += "\n";
		for (int i = 0; i < stdCnt; i++) {
			data += list[i].id;
			data += ",";
			data += list[i].pw;
			if (stdCnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
		
	}
	
	
	
	void sort_data() {
		
		for (int i = 0; i < stdCnt; i++) {
			for (int n = 0; n < stdCnt ; n++) {
				if (list[i].id.compareTo(list[n].id) > 0) {
					StudentEx temp = list[i];
					list[i] = list[n];
					list[n] = temp;
				}
			}
		}
		
	}
	
	
	
	void load_StudentEx (StudentEx [] temp , int count) {
		
		this.stdCnt = count;
		this.list = temp;
		
	}
	
}


public class ClassArrayEx13_정답T {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager();
		
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StudentEx temp = new StudentEx();
				System.out.println("[가입] id 를 입력하세요 >>> ");
				temp.id = scan.next();			
				int check =  manager.check_id(temp);
				
				if(check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next();
					manager.add_StudentEx(temp);	
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) {
				
				manager.print_StudentEx();
				StudentEx temp = new StudentEx();
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				int check = manager.check_id(temp);
				
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {
					StudentEx del_st = manager.remove_StudentEx(check);
					System.out.println(del_st.id + "님 탈퇴 되었습니다.");
				}
				
			}
			else if (sel == 3) {
				
				manager.sort_data();
				manager.print_StudentEx();
				
			}
			else if (sel == 4) {
				
				manager.print_StudentEx();
				
			}
			else if (sel == 5) {
				
                if (manager.stdCnt == 0) continue;
				
                try {
                	
					FileWriter fw =new FileWriter("StudentEx_manager.txt");
					String data = manager.out_data();
					if (!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					fw.close();	
					
				} catch (Exception e) {e.printStackTrace();}
                
			}
			else if(sel == 6) {
				
				try {
					
					File file = new File("StudentEx_manager.txt");
					
					if (file != null) {
						
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						
						String line = br.readLine();
						int count = Integer.parseInt(line);
						StudentEx [] temp = new StudentEx[count];
						
						for (int i = 0; i < count; i++) {
							temp[i] = new StudentEx();
							line = br.readLine();
							String value[] = line.split(",");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}
						
						fr.close();
						br.close();
						
						manager.load_StudentEx(temp , count);
						
					}
					
					manager.print_StudentEx();
				}
				catch (Exception e) {e.printStackTrace();}
									
			}
			else if (sel == 7) {
				System.out.println("종료");
				break;
			}
			
		}

		scan.close();
		
	}

}
