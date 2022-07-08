package chapter01;

public class Loop02 {
	public static void main(String[] args) {
		//과목: kor, eng
		int[][] jumsuArr = {
				{90,80},{95,75},{100,90},{95,85},{80,100}
		};
		
		//while문을 사용하여 다음과 같이 출력해보자
		//kor의 평균 : 90
		//eng의 평균 : 90
		int i = 0;
		int j = 0;
		jumsuArr[i][j];
		int korSum = 0;
		int korAvg = 0;
		while (i<jumsuArr.length) {
			korSum = korSum + jumsuArr[i];
			i++;
		}
		while(j<jumsuArr[i].length) {
				j++;
		}
		
		korAvg = korSum / jumsuArr.length;
		System.out.println("kor의 평균:" + korAvg);
	}
}
