// 2020-11-03 화 2교시 강의
package step7_01.classArray;

// # ArrayList와 Array의 사용기능 비교

public class ClassArrayEx19_reference {

	public static void main(String[] args) {

//		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[100];	
	
//		list.add(10);
//		list.add(20);
//		list.add(30);
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
//		list.set(2, 300);
		arr[2] = 300;

//		list.remove(2);
		arr[2] = 0;
		
		for (int i = 0; i < arr.length; i++) { // list.size();
			System.out.println(arr[i]);
//			System.out.println(list.get(i));
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		
//		list.clear();
		arr = null;
		
		
	
	}

}
