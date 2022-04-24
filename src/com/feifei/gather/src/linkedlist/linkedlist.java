package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
//链表 链表 （也有队列的功能  这里使用 链表的功能）
public class linkedlist {

	public static void main(String[] args) {

		LinkedList<Integer> monkeys = new LinkedList<Integer>();
		int number,cnt;
		
		for(number = 1;number<=100;number++){
			monkeys.addLast(number);//将给定元素追加到此列表的结尾。
		}
		
		cnt = 100;
		number = 0;
		Iterator it = monkeys.iterator();//获得迭代器
		while(cnt>1){
			
			if(it.hasNext()){//当为 false时   说明到了链表的结尾  需要从头开始
				it.next();//迭代器 向后走
				number++;
			}
			else{
				it = monkeys.iterator();//模拟循环链表  从头开始  从头开始 没有跨 结点 所以number不用加1
			}
			//删除应该删除的猴子
			if(number == 14){//约瑟夫  报的数字是14  这个数字 可以任意定
				number = 0;
				it.remove();//从链表中删除
				cnt --;
			
			}
		}
		
		System.out.println(monkeys.element());//element()找到但不移除此列表的头（第一个元素）。 
	}

}
