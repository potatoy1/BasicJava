package chapter02;

public class Confirm209 {
	public static void main(String[] args) {
		long var1 = 2;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result = (int) (var1 + var2 + var3 + (int) Double.parseDouble(var4));
		System.out.println(result);
	}
}