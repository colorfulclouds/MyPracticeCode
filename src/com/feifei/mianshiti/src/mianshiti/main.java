package mianshiti;

import java.util.Scanner;

/*
 * ������Ƭ  ����Ƭ������������Сֵ���ܺ͵ĳ˻� �����ֵ��
 * 
 * 
 * */
public class main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] array = new int[num];

		for (int i = 0; i < num; i++) {
			array[i] = sc.nextInt();
		}
		// ��ʼ����ǰ���ֵ
		int curMax = 0;

		for (int i = 0; i < num; i++) {
			int curMin = array[i];
			int curSum = 0;

			for (int j = i; j < num; j++) {
				if (array[j] == 0)
					break;

				curSum += array[j];

				if (curMin > array[j])
					curMin = array[j];

				if (curMin * curSum > curMax)
					curMax = curMin * curSum;

			}
		}

		System.out.println(curMax);

		// Collections.sort(array);
		// for (int i = 0; i < num; i++) {
		// System.out.println(array.get(i));
		// }
	}

}