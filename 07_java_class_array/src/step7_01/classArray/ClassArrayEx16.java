// 2020-11-02 월 3교시 설명3
package step7_01.classArray;

/*
 *  # 생성자 오버로딩
 *   - 생성자도 메서드이기 때문에 메서드 오버로딩 기법이 적용 가능하다. 
 *   - 생성자 오버로딩을 구현하기 위해서는 일반 메서드와 마찬가지로 
 *   	파라메타의 개수나 타입을 다르게 정의하면 된다. 
 	 
 	 - 똑같은거 여러개 할 수 있다. 
	 - this()로 생성자 내에서 본인 자신의 생성자를 또 부를 수 있다. 
 */
class Fruit2 {
	String name;
	int price;
	
	Fruit2() {
		this.name = "과일";
		this.price = 0;
		
//		this();	// 본인의 생성자 호출 
//		this("과일", 0);
//		this("과일");
	}
	
	// 생성자 오버로딩
	Fruit2 (String name){
//		this.name = name;
		this(name, 0);	// 다른 생성자 (매개변수 2개) 호출 
	}

	Fruit2(String name, int price){
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

public class ClassArrayEx16 {

	public static void main(String[] args) {
		Fruit2 f1 = new Fruit2(); 
		f1.printData();
		
		Fruit2 f2 = new Fruit2("사과");
		f2.printData();
		
		Fruit2 f3 = new Fruit2("토마토", 100);
		f3.printData();
	}
}
