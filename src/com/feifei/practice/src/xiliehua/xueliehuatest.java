package xiliehua;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import practice.example;

public class xueliehuatest {

	public static void main(String[] args)  throws Exception{

		employee e1 = new employee("yufeifei", 20, 10000);
		employee e2 = new employee("xiaoyu", 21, 5632.25);
		employee e3 = new employee("chunmei", 18, 5820);
		
		FileOutputStream fos = new FileOutputStream("F:\\i.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(e3);
		oos.close();
		
		FileInputStream fis = new FileInputStream("F:\\i.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		employee e;
		for(int i  =0;i<3;i++){
			
			e= (employee) ois.readObject();
			System.out.println(e.name+e.age+e.salary);
			
		}
		ois.close();
		
	}

}

class employee implements Serializable{
	
	String name;
	int age;
	transient double salary;
	
	transient Thread th = new Thread();
	
	public employee(String name,int age,double salary) {

		this.name = name;
		this.age = age;
		this.salary = salary;
		
	}
	
	private void writeObject(java.io.ObjectOutputStream oos) throws IOException{
		
		oos.writeInt(age);

		oos.writeUTF(name);
		
		System.out.println("write object");
	}
	
	private void readObject(java.io.ObjectInputStream ois)throws IOException{
		
		age = ois.readInt();
		name =ois.readUTF();
		System.out.println("read object");
		
	}
	
	
}