package lei_biao_ji;

import java.io.IOException;

public class start_exe {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		try {
			System.out.println(r.maxMemory()+".."+r.totalMemory());//�鿴����ڴ���Ϣ
			
			
			r.exec("notepad");//����PC�ϵļ��±�  ֱ�ӵ����ⲿ����  ��Ϊ���������ӽ���
		
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
