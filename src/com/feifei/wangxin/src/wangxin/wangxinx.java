package wangxin;

import java.util.Scanner;

public class wangxinx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line[];
		String nextLine;
		int left, right;
		int sum[] = new int[100];
		
		while (scanner.hasNext()) {
			nextLine = scanner.nextLine();
			line = nextLine.split(",");
			left = Integer.parseInt(line[0]);
			right = Integer.parseInt(line[1]);
			if (left == -1 && right == -1) {
				break;
			}
			for (int i = left; i < right; i++) {
				sum[i]++;
			}
		}
		for (int i = 12; i < 20; i++) {
		System.out.println("[" + i + "," + (i + 1) + "):" + sum[i]);
		}
		scanner.close();
	}
}
