package chapter01;

public class Loop01 {
	public static void main(String[] args) {
		int[] jumsu = { 89, 90, 70, 75, 100, 95, 95, 80, 75, 85 };

		// jumsu�� ����� ���غ���(while������ ó���غ���)
		int i = 0;
		int sum = 0;
		int avg = 0;
		while (i<jumsu.length) {
			sum += jumsu[i];
			i++;
		}
		avg = sum / jumsu.length;
		System.out.println(avg);
	}
}
