package iostream;

import java.io.*;

public class re_iostream {

	public static void main(String [] args){
		PrintStream ps = System.out;//����ԭ����console�������
		
		try {
			PrintStream new_ps = new PrintStream("1.txt");//�ض���
			System.setOut(new_ps);//�ض����µ������
			System.out.println("kk");//����ʾ�ڿ���̨  ���Ǵ�ӡ���ı��ļ���
			System.setOut(ps);//���¶�λ��ȥ����̨�����
			System.out.println("nn");//��ӡ�ڿ���̨��
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
