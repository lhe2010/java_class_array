// 2020-11-03 화 3교시 17:23-17:48
// 2020-11-04 수 1교시 15:10-15:20
package step7_01.classArray;

//# ArrayList 클래스의 기능을 직접 구현해보자!

class MyList {

	int[] arr;
	int eCnt;

	void print() {
		System.out.print("[");
		for (int i = 0; i < this.eCnt; i++) {
			System.out.print(arr[i]);
			if(i != eCnt-1)
				System.out.print(", ");
		}
		System.out.print("]\n");
	}
	
	void add(int value) {
		if(eCnt == 0) {
			arr = new int[eCnt+1];
		} else {
			int[] temp = arr;
			arr = new int[eCnt+1];
			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
			temp = null;
		}
		arr[eCnt++] = value;
	}
	
	void add(int index, int value) {
		if(eCnt == 0) {
			this.add(value);
		} else {
			int[] temp = arr;
			arr = new int[eCnt+1];
			
			int j = 0;
			for (int i = 0; i < this.eCnt+1; i++) {
				if(i != index) 
					arr[i] = temp[j++];
			}
			temp = null;
			arr[index] = value;
		}
		this.eCnt++;
	}
	
	void remove(int index) {
		if(eCnt == 1) {
			this.arr = null;
		} else {
			int[] temp = arr;
			arr = new int[eCnt-1];
			
			int j = 0;
			for (int i = 0; i < this.eCnt; i++) {
				if(i != index) {
					arr[j++] = temp[i];
				}
			}
			temp = null;
		}
		eCnt--;
	}

	int size() {
		return this.eCnt;
	}
	
	int get(int index) {
		return this.arr[index];
	}

	void set(int index, int value) {
		this.arr[index] = value;
	}

	void clear() {
		this.arr = null;
		this.eCnt = 0;
	}

}


public class ClassArrayEx20_정답 {

	public static void main(String[] args) {

		// 직접 구현한 ArrayList
		MyList list = new MyList();

		// 추가하기
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		// 삽입하기
		list.add(0, 9);
		// 출력하기
		list.print();

		// (index로)삭제하기
		list.remove(3);
		list.print();

		// 길이 구하기
		int elementCnt = list.size();
		System.out.println("elementCnt = " + elementCnt);

		// (index로)값 꺼내오기
		System.out.print("[");
		for (int i = 0; i < elementCnt; i++) {
			System.out.print(list.get(i));
			if (i != elementCnt - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		// 특정 위치의 값 수정하기
		list.set(3, 5);
		list.print();

		// 모든 데이터를 제거하기
		list.clear();
		System.out.println(list.size());

	}

}
