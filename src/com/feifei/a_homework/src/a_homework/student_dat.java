package a_homework;

import java.io.*;
import java.util.*;

public class student_dat {
	public static void main(String [] args) throws IOException{

		File file = new File("student.dat");
		FileOutputStream fos = new FileOutputStream(file);
		
		int num;
		String name;
		float[]grade = new float[3];//���Ƴɼ�
		Scanner reader = new Scanner(System.in);
		String info = "";
		
		for(int i = 0;i<5;i++){
			info = "";
			System.out.print("ѧ��:");
			num = reader.nextInt();
			info += num;
			info +="  ";
			System.out.print("����:");
			name = reader.next();
			info += name;
			info +="  ";
			System.out.print("�ɼ�:");
			for(int j = 0;j<3;j++){
				grade[j] = reader.nextFloat();
				info += grade[j];
				info +="  ";
			}
			info += "\r\n";
			System.out.println(info);	
			fos.write(info.getBytes());
		}
		fos.close();
		///�����ļ�
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
		ArrayList <Integer> _num = new ArrayList<Integer>();
		ArrayList <String> _name = new ArrayList<String>();
		//byte[] _info = new byte[20];
		//for(int i = 0;i<5;i++){
			//_num.add(bis.readLine().getBytes());
		//}
		
		//���ļ���ָ���� ��ȡָ���е����� 		���λ�ȡѧ�� ���� ���ſγ̳ɼ�
	}

}
