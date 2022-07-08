package chapter01;

public class Hello1 {
	public static void main(String[] args) {
		int dan = 2;
		int num = 1;
		while (dan <= 9) {
			System.out.println(dan + "��");

			while (num <= 9) {
				System.out.println(dan + "X" + num + "=" + num * dan);
				num++;
			}
			num = 1;
			dan = dan + 1;
		}
	}
}
