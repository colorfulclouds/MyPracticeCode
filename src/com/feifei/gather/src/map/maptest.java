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
		Map map = new LinkedHashMap();//和HashMap的不同就是  遍历的顺序 和添加的顺序是一样的  因为在添加的时候 通过链表维持整个的集合
		
		map.put(123, "yufeifei");
		map.put(true, 15.5);
		map.put(12.5f, "wangxin");
		
		map.put(new people(15,"yufeifei"),"haha");
		map.put(new people(15,"yufeifei"),"lklkl");
//		map.put(12.5f, "weihang");
		
//		System.out.println(map);
//		System.out.println(map.size());
		
		/*
		 * 遍历key
		 */
		Set set = map.keySet();
		for(Object obj:set){
			System.out.println(obj);
		}
		/*
		 * 遍历values	内部实现 也是通过key去找到value
		 */
		System.out.println();
		Collection values = map.values();
		Iterator i = values.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		/*
		 * 遍历entry(key-value对)
		 */
		System.out.println();
		Set set2 = map.entrySet();
		for(Object obj : set2){
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey() +"  "+entry.getValue());
//			System.out.println(entry);//和上面的效果一样 只是多了一个等号
			}
	}
	
	
}
