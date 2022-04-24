package eight_queen;

public class _eight_queen {

	static final int QUEEN_COUNT = 16; // 是多少皇后
	static final int EMPTY = 0;
	int[][] count = new int[QUEEN_COUNT][QUEEN_COUNT];
	int[] QueenIndex = new int[QUEEN_COUNT];
	int resultCount = 0;

	public void putQueenIndex(int row) {
		for (int col = 0; col < QUEEN_COUNT; col++) {
			if (count[row][col] == EMPTY) {
				for (int iRow = row + 1; iRow < QUEEN_COUNT; iRow++) {
					count[iRow][col]++;
					if ((col - iRow + row) >= 0) {
						count[iRow][col - iRow + row]++;
					}
					if ((col + iRow - row) < QUEEN_COUNT) {
						count[iRow][col + iRow - row]++;
					}
				}
				QueenIndex[row] = col;
				if (row == QUEEN_COUNT - 1) {
					++resultCount;
				} else {
					putQueenIndex(row + 1);
				}
				for (int iRow = row + 1; iRow < QUEEN_COUNT; iRow++) {
					count[iRow][col]--;
					if ((col - iRow + row) >= 0) {
						count[iRow][col - iRow + row]--;
					}
					if ((col + iRow - row) < QUEEN_COUNT) {
						count[iRow][col + iRow - row]--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		_eight_queen obj = new _eight_queen();
		long time = System.currentTimeMillis();
		obj.putQueenIndex(0);
		long useTime = System.currentTimeMillis() - time;
		System.out.println(QUEEN_COUNT + "皇后共有 " + obj.resultCount + " 个解\n"
				+ useTime + "毫秒");
	}
}