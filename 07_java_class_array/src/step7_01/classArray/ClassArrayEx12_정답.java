// 2020-10-30 금 2교시 16:47-16:51
// 2020-10-30 금 3교시 17:08-17:25 

package step7_01.classArray;

// 문자열(2단계) [문제]
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

public class ClassArrayEx12_정답 {

	public static void main(String[] args) {
		
        // data의 정보를 클래스배열에 저장.
		// 첫번째 /는 인덱스이다.
		// 두번째 /는 데이터의 개수이다.
		// 두번째 / 이후부터 data의 정보이다.
		
		Test[] t;
		String data ="6\n";						// Test의 크기
		data += "0/2/a/b\n";					// 인덱스 / 데이터개수 / 데이터 ~~
		data += "1/3/a/b/c\n";					// 인덱스 / 데이터개수 / 데이터 ~~
		data += "2/5/a/b/c/d/e\n";				// 인덱스 / 데이터개수 / 데이터 ~~
		data += "3/4/a/b/c/d\n";				// 인덱스 / 데이터개수 / 데이터 ~~
		data += "4/3/a/b/c\n";					// 인덱스 / 데이터개수 / 데이터 ~~
		data += "5/1/a";						// 인덱스 / 데이터개수 / 데이터 ~~

		String[] temp = data.split("\n");
		int size = Integer.parseInt(temp[0]);
		//
		t = new Test[size];		// test를 담는 배열을 할당한것일 뿐!! 만들어야지!!!!	
		for (int i = 0; i < size; i++) {
			String[] info = temp[i+1].split("/");
			t[i] = new Test(); 	// test를 담는 배열 t에 test객체를 생성!!!!!!!! 안하니까 NullException뜸  
			t[i].num = Integer.parseInt(info[0]);
			t[i].size = Integer.parseInt(info[1]);
			t[i].data = new char[t[i].size];
			// 정답t랑 비교해보기. 
			int tempData = 0;
			for (int j = 2; j < info.length; j++) {
				t[i].data[tempData++] = info[j].charAt(0); 
				// String to Char?????******
				// wrong : (char) Integer.parseInt(info[j]) ==> charAt이용
			}
		}
		
		// 프린트하기
		for (int i = 0; i < t.length; i++) {
			t[i].print();
		}
	}
}
