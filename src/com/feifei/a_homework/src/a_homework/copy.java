package a_homework;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

class student implements Serializable,Comparable<student>{
	
	private String name;//姓名
	private int age;//年龄
	private String num;//学号
	private float grade;//分数
	
	public student(String name,int age,String num,float grade){
		this.name = name;
		this.age = age;
		this.num = num;
		this.grade = grade;
	}
	
	public void show(){
		System.out.println(name);
		System.out.println(age);
		System.out.println(num);
		System.out.println(grade);
	}

	public int compareTo(student o) {
		
		/*if(grade > o.grade)
			return 1;*/
		if(grade < o.grade)
			return -1;
		return 0;
	}

	
}
public class copy{

	public static void main(String [] args) throws IOException, ClassNotFoundException{
		
		FileOutputStream fos = new FileOutputStream("student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
		student []stu = new student[4];
		int i = 0;
		student stu2 = new student("yufeifei",20,"04133023",100);
		student stu1 = new student("yangshuai",21,"04133024",98);
		student stu3 = new student("weihang",19,"04133025",97);
		student stu4 = new student("tianzhao",20,"04133026",96);
		
		oos.writeObject(stu1);
		oos.writeObject(stu2);
		oos.writeObject(stu3);
		oos.writeObject(stu4);
		while(true){
			try{
				stu[i++] = (student) ois.readObject();
				
			}catch (EOFException e) {
				break;
			}
		}
		
		//Arrays.sort(stu);
		
		for(student s:stu){
			s.show();
			System.out.println("********");
		}
			
		
		oos.close();
		fos.close();
		
	}

	
}
