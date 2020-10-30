// 2020-10-30 금 2교시 16:37-16:47
package step7_01.classArray;

// 문자열(1단계)[문제]

class Student{

	String name;
	int score;
	
	void print() {
		System.out.println(this.name + " : " + this.score);
	}
	
}


public class ClassArrayEx11_정답 {

	public static void main(String[] args) {
		
		String data = "3\n"; 				// studentList의 크기
		data +="김영희/30\n";				// 이름/성적
		data += "이만수/40\n";
		data += "이철민/60";
		
		Student[] sList;
		
		//문제) data에 있는 내용을 잘라서 StudentList에 저장후 출력 하시오.
		String[] sData = data.split("\n");
		sList = new Student[Integer.parseInt(sData[0])];
		
		for (int i = 0; i < sList.length; i++) {
			sList[i] = new Student();
			sList[i].name = sData[i+1].split("/")[0];
			sList[i].score = Integer.parseInt(sData[i+1].split("/")[1]);
		}
		
		// print
		for (int i = 0; i < sList.length; i++) {
			sList[i].print();
		}
	
		

	}

}
