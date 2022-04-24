package lei_biao_ji;

import java.io.IOException;

public class start_exe {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		try {
			System.out.println(r.maxMemory()+".."+r.totalMemory());//查看相关内存信息
			
			
			r.exec("notepad");//调用PC上的记事本  直接调用外部程序  作为自身程序的子进程
		
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
