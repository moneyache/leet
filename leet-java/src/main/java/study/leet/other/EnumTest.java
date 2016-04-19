package study.leet.other;

public enum EnumTest {

	QT("qt",1), QQT("qqt", 2);
	private String name;
	private int index;
	private EnumTest(String name, int index) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.index = index;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + index;
	}
	public static void main(String[] args) {
	}
}
