public class d52Q2kadai {
	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.test();
	}
}

class Temper {
	private double temperature; //温度

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}

class Tester {
	public void test() {
		Temper t = new Temper();
		t.setTemperature(17.2);
		System.out.println(t.getTemperature());
	}
}
