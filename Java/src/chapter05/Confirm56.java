package chapter05;

import java.util.Scanner;

public class Confirm56 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		int setNum;
		int bestScore = 0;
		int sum = 0;
		double avg = 0;

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택");

			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 1) {
				System.out.println("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]>");
					setNum = Integer.parseInt(scanner.nextLine());
					scores[i] = setNum;
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]>" + scores[i]);
				}
			} else if (selectNo == 4) {
				for (int i = 0; i < scores.length; i++) {
					if (bestScore < scores[i]) {
						bestScore = scores[i];
					}
					sum += scores[i];
				}
				System.out.println("최고 점수: " + bestScore);
				avg = (double) sum / scores.length;
				System.out.println("평균 점수: " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}