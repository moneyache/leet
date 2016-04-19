package study.leet.other;

public class Main {
	
	public String testString = "test";
	public  String changeStr(String string) {
		System.out.println(string == testString);
		string += "changed";
		System.out.println(string == testString);
		return string;
	}
	public static class MyObj{
		public final int myInt;
		public final String myStr;
		public MyObj(int myInt, String myStr) {
			// TODO Auto-generated constructor stub
			this.myInt = myInt;
			this.myStr = myStr;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "MyInt is:" + myInt + " myStr is:" + myStr;
		}
		
	}
	public  void changeValue(int a) {
		System.out.println("in function , before change int is :" + a);
		a += 10;
		System.out.println("in function , int changed to be" + a);
	}
	public  void changeRef(MyObj obj) {
		System.out.println("in function , before change obj is \n" + obj);
		//obj.myStr += "changed";
		//obj.myInt += 10;
		obj = new MyObj(10, "newMyObj");
		System.out.println("in function , obj changed to be \n" + obj);
	}
	public  void changeString(String str) {
		System.out.println("in function , before change str is \n" + str);
		str += "changed";
		System.out.println("in function , str changed to be \n" + str);
	}
	public static void main(String[] args) {
		String aString = "a";
		Main main = new Main();
		System.out.println(main.changeStr(main.testString));
		/*int a = 0;
		final MyObj myObj = new MyObj(0, "new");
		main.changeRef(myObj);
		System.out.println("out function , obj changed to be \n" + myObj);*/
		//main.changeValue(a);
		//System.out.println("out function , int changed to be \n" + a);
		/*String aString = "a";
		main.changeString(aString);
		System.out.println("out function , str changed to be \n" + aString);*/
	}
}
