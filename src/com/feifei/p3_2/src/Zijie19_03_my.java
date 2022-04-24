import java.util.Scanner;


public class Zijie19_03_my {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int grps = sc.nextInt();  //组数
	
		for (int i = 0; i < grps; i++) {
			int num = sc.nextInt();
			//加长数组
			int[] arr = new int [num+2];
			
			for (int j = 1; j < num+1; j++) {
				arr[j] = sc.nextInt();
			}
			
			arr[0] = arr[num]; 
			arr[num+1] = arr[1];
			
			//辅助 奖励
			int[] helparr = new int [num+2];
			
			for (int j = 0; j < num+2; j++) {
				helparr[j] = 1;
			}
			
			//遍历设置奖品数
			int cnt = 0;
			for (int j = 1; j < num+1; j++) {
				if(arr[j]>arr[j-1] && helparr[j]<=helparr[j-1]) {
					helparr[j] = helparr[j-1]+1;
				}
			}
			helparr[num+1] = helparr[1];
			for (int j = num; j >0; j--) {
				if(arr[j]>arr[j+1] && helparr[j]<=helparr[j+1]) {
					helparr[j] = helparr[j+1]+1;
				}
				cnt+=helparr[j];
			}			
			System.out.println(cnt);			
		}
	}
}

//用例1：
//1
//7
//5 1 3 2 1 4 8
//14
//用例2：
//1
//2
//1 2

/*
* 非要撩哧我 
* 不过看到还是很开心的
* 这不
* 代码是在（看你的图解之后 && 看你的代码之前）自己想着打出来的呢（*_*）
* */
