package eight_queen;

import java.util.Calendar;

public class __eight_queen {

	public static int sum = 0, upperlimit = 1;

	public static void compute(int row, int ld, int rd) {

		if (row != upperlimit) {
			int pos = upperlimit & ~(row | ld | rd);
			while (pos != 0) {
				int p = pos & -pos;
				pos -= p;
				compute(row + p, (ld + p) << 1, (rd + p) >> 1);
			}

		} else
			sum++;
	}

	public static void main(String[] args) {
		Calendar start;
		int n = 8;
		if (args.length > 0)
			n = Integer.parseInt(args[0]);
		start = Calendar.getInstance();
		if ((n < 1) || (n > 32)) {
			System.out.println(" ֻ�ܼ���1-32֮��\n");
			return;
		}
		System.out.println(n + " �ʺ�\n");
		upperlimit = (upperlimit << n) - 1;
		compute(0, 0, 0);
		System.out.println("����"
				+ sum
				+ "������, ����ʱ��"
				+ (Calendar.getInstance().getTimeInMillis() - start
						.getTimeInMillis()) / 1000 + "�� \n");
	}

}