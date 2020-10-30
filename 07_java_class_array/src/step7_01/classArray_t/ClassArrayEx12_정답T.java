package step7_01.classArray_t;

// 문자열(2단계)[정답]

class Test{
	
	int num;	  // 인덱스
	int size;	  // 데이터의 개수
	char[] data;  // 데이터의 저장 배열
	
	void print() {
		for(int i=0; i<size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
}


public class ClassArrayEx12_정답T {

	public static void main(String[] args) {
		
		String data ="6\n";						// Test의 크기
		data += "0/2/a/b\n";					// 인덱스 / 데이터개수 / 데이터 ~~
		data += "1/3/a/b/c\n";					// 인덱스 / 데이터개수 / 데이터 ~~
		data += "2/5/a/b/c/d/e\n";				// 인덱스 / 데이터개수 / 데이터 ~~
		data += "3/4/a/b/c/d\n";				// 인덱스 / 데이터개수 / 데이터 ~~
		data += "4/3/a/b/c\n";					// 인덱스 / 데이터개수 / 데이터 ~~
		data += "5/1/a";						// 인덱스 / 데이터개수 / 데이터 ~~

		// data의 정보를 클래스배열에 저장.
		// 첫번째 /는 인덱스이다.
		// 두번째 /는 데이터의 개수이다.
		// 두번째 / 이후부터 data의 정보이다.

		Test[] t;	
	
		String[] temp = data.split("\n");
		int size = Integer.parseInt(temp[0]);
		
		t = new Test[size];
		
		for (int i=0; i<size; i++) {
			t[i] = new Test();
		}
		
		for (int i=0; i<size; i++) {
			
			String[] info = temp[i + 1].split("/");
			
			t[i].num = Integer.parseInt(info[0]);
			t[i].size = Integer.parseInt(info[1]);
			
			t[i].data = new char[t[i].size];
			
			int k = 2;
			for (int j=0; j<t[i].data.length; j++) {
				t[i].data[j] = info[k].charAt(0);
				k++;
			}
			
		}
		
		for (int i=0; i<size; i++) {
			t[i].print();
		}

	}

}
