package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class maptest {

	public static void main(String[] args) {
		
		//Map map = new HashMap();
		Map map = new LinkedHashMap();//��HashMap�Ĳ�ͬ����  ������˳�� ����ӵ�˳����һ����  ��Ϊ����ӵ�ʱ�� ͨ������ά�������ļ���
		
		map.put(123, "yufeifei");
		map.put(true, 15.5);
		map.put(12.5f, "wangxin");
		
		map.put(new people(15,"yufeifei"),"haha");
		map.put(new people(15,"yufeifei"),"lklkl");
//		map.put(12.5f, "weihang");
		
//		System.out.println(map);
//		System.out.println(map.size());
		
		/*
		 * ����key
		 */
		Set set = map.keySet();
		for(Object obj:set){
			System.out.println(obj);
		}
		/*
		 * ����values	�ڲ�ʵ�� Ҳ��ͨ��keyȥ�ҵ�value
		 */
		System.out.println();
		Collection values = map.values();
		Iterator i = values.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		/*
		 * ����entry(key-value��)
		 */
		System.out.println();
		Set set2 = map.entrySet();
		for(Object obj : set2){
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey() +"  "+entry.getValue());
//			System.out.println(entry);//�������Ч��һ�� ֻ�Ƕ���һ���Ⱥ�
			}
	}
	
	
}
