// 2020-11-03 화 3교시 17:10-17:23
package step7_01.classArray;

import java.util.ArrayList;

class Tv {
	
	String name;
	String brand;
	int price;

	Tv (String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
}

class TvList {
	
	Tv[] arr;
	int eCnt;

	void add(Tv e) {
		if(eCnt == 0) {
			arr = new Tv[1];
		} else if(eCnt > 0) {
			Tv[] temp = arr;			// temp를 새로 만들어서 나중에 arr = temp하는 것 보다 이게 낫다. 
			arr = new Tv[eCnt+1];
			
			for (int i = 0; i < this.eCnt; i++) {
				arr[i] = temp[i];
			}
		}
		arr[this.eCnt++] = e;
	}

	int size() {
		return eCnt;
	}

	void remove(int index) {
		if(index >= eCnt) return;
		if(eCnt == 1) {
			arr = null;
		} else {
			Tv[] temp = arr;
			arr = new Tv[eCnt-1];
			for (int i = 0; i < index; i++) 
				arr[i] = temp[i];
			for (int i = index; i < temp.length; i++) 
				arr[i] = temp[i+1];
			/*
			 * for (int i = 0; i < elementCount; i++) {
				if (i != index) {
					arr[j] = temp[i];
					j += 1;
				}
			}
			 */
		}
		this.eCnt--;
	}

	Tv get(int index) {
		return this.arr[index];
	}
}


public class ClassArrayEx21_정답 {

	public static void main(String[] args) {
		
		// ArrayList 사용
		ArrayList<Tv> list = new ArrayList<>();

		Tv temp = new Tv("TV", "삼성", 1000);
		list.add(temp);

		temp = new Tv("시그니처TV", "엘지", 2000);
		list.add(temp);

		temp = new Tv("스마트TV", "애플", 3000);
		list.add(temp);

		temp = list.get(1);
		System.out.println(temp.name);

		// --------------------------------------------

		// 직접 구현한 ArrayList 사용
		TvList myList = new TvList();
		temp = new Tv("TV", "삼성", 1000);
		myList.add(temp);

		temp = new Tv("시그니처TV", "엘지", 2000);
		myList.add(temp);

		temp = new Tv("스마트TV", "애플", 3000);
		myList.add(temp);

		temp = myList.get(1);
		System.out.println(temp.name);

	}

}
