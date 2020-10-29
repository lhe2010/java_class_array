package step7_01.classArray;

class Member{
	String name;
	int num;
}

class MemberManager{
	Member[] memberList = new Member[3];
}


public class ClassArrayEx06 {

	public static void main(String[] args) {

		MemberManager mg = new MemberManager();	
		Member m1 = new Member();
		mg.memberList[0] = m1;
		m1.name = "김철수";
		m1.num = 1001;
		
		m1 = new Member();
		mg.memberList[1] = m1;
		m1.name = "이만수";
		m1.num = 1002;
		
		m1 = new Member();
		mg.memberList[2] = m1;
		m1.name = "박영희";
		m1.num = 1003;
		
		for (int i = 0; i < mg.memberList.length; i++) {
			System.out.println("num : " + mg.memberList[i].num);
			System.out.println("name : " + mg.memberList[i].name);
			System.out.println();
		}
		
		Member temp = mg.memberList[1];
		System.out.println(temp.name);

	}

}
