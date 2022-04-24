package vector;

import java.util.*;
public class vector {
//向量
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
	Iterator it = v.iterator();//获得迭代器
	while(it.hasNext()){
		System.out.println(it.next());
	}
	}

}
