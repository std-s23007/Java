// s23007
// ポリモーフィズムの課題

// スーパークラスの定義
class Rion {
	public void makeSound() {
		System.out.println("pritl");
	}
}


class Animal {
	public void makeSound() {
		System.out.println("");
	}

	public void test() {
		System.out.println("テスト出力");
	}
}


// 継承したサブクラスDogの定義
class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("ワンワン");
	}
}


// 継承したサブクラスCatの定義
class Cat extends Animal {
	@Override
	public void makeSound() {
		System.out.println("ニャー");
	}
}


public class d48Q2kadai {
	public static void main(String[] args) {
		Animal a = new Dog(); // インスタンス化
		Animal b = new Cat(); // インスタンス化
		a.makeSound(); // どのような処理になるでしょう？
		a.test(); // どのような処理になるでしょう
		b.makeSound();
		b.test();
	}
}
