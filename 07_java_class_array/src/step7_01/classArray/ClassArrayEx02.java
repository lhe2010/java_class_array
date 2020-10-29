// 2020-10-29 목 설명 - 객체배열 
package step7_01.classArray;

class Card {
	// 멤버변수 == 인스턴스변수 == 객체변수
	int num;
	String shape; 
}

public class ClassArrayEx02 {

	public static void main(String[] args) {
		
		Card[] arr = new Card[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Card(); 		// new 두번!
			arr[i].num = (i+1);
			arr[i].shape = "클로버";
		}
		
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("num : %d\nshape : %s\n",arr[i].num, arr[i].shape);
		}
	}
}
