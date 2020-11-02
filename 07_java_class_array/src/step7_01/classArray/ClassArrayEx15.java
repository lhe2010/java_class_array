// 2020-11-02 월 3교시 설명2
package step7_01.classArray;

// # 생성자를 이용한 멤버변수 초기화

class Fruit {
	String name;
	int price;

	Fruit(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	void printData() {
		System.out.println(this.name + "(" + this.price + "원)");
	}
}

public class ClassArrayEx15 {

	public static void main(String[] args) {
		/*
		// 1. 직접
		Fruit f = new Fruit(); // *** 생성자에 매개변수가 2개 있으므로 에러!!
		f.name = "사과";
		f.printData();
		
		// 2. setter 이용
		Fruit f2 = new Fruit();
		f2.setName("토마토");
		f2.printData();
		*/
		
		// 3. 생성자 이용
		Fruit f3 = new Fruit("메론", 500);
		f3.printData();
		
		// Scanner scan = new Scanner(System.in);

	}

}
