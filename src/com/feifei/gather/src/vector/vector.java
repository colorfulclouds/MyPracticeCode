package vector;

import java.util.*;
public class vector {
//����
	public static void main(String[] args) {

	Vector<String> 	v = new Vector<String>();
	v.add("yufeifei");
	v.add("wangxin");
	v.add("lijing");
	v.add("yangshuai");
	
	System.out.println("number:"+v.size());
	//showVector(v);
	v.remove("yufeifei");
	v.remove(2);
	Iterator it = v.iterator();//��õ�����
	while(it.hasNext()){
		System.out.println(it.next());
	}
	}

}
