// 2020-11-03 화 1교시 강의
package step7_01.classArray;
/*
 * # 접근제어자 : public, private
 * # getter/setter
 */

class PrivateTest{
	private int a;
	int b;
	int c;
	int age;
	
	// private변수를 외부로 꺼내주는 메서드 getter
	int getA() {
		return this.a;
	}
	
	// private변수에 외부에서 값을 설정하는 메서드 setter 
	void setA(int a) {
		this.a = a;
	}
	
	void setAge(int age) {
		if(age < 0) return; // age가 -1처럼 정상적이지 않은 경우라면
		else				// 정상적이지 않은 데이터를 처리가능 
			this.age = age;
	}
	
	int getAge() {
		return this.age;
	}
	
	/*
	 *  # getter/setter 자동완성
	 *  > 이클립스 좌측 상단 Source
	 *  > Generate getters and setters
	 */
}

public class ClassArrayEx17 {

	public static void main(String[] args) {
		PrivateTest obj = new PrivateTest();
		
//		obj.a		// 접근불가
		obj.b = 1000;
		obj.c = 2000;
		System.out.println(obj.b);
		System.out.println(obj.c);
		
		obj.setA(10);					// setter를 이용하여 값 대입
		System.out.println(obj.getA());	// getter를 이용하여 값 가져오기 
		
		obj.age = -1;
		obj.setAge(-1);
	}
}
