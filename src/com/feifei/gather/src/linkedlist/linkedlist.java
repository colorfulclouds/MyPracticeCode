package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
//���� ���� ��Ҳ�ж��еĹ���  ����ʹ�� ����Ĺ��ܣ�
public class linkedlist {

	public static void main(String[] args) {

		LinkedList<Integer> monkeys = new LinkedList<Integer>();
		int number,cnt;
		
		for(number = 1;number<=100;number++){
			monkeys.addLast(number);//������Ԫ��׷�ӵ����б�Ľ�β��
		}
		
		cnt = 100;
		number = 0;
		Iterator it = monkeys.iterator();//��õ�����
		while(cnt>1){
			
			if(it.hasNext()){//��Ϊ falseʱ   ˵����������Ľ�β  ��Ҫ��ͷ��ʼ
				it.next();//������ �����
				number++;
			}
			else{
				it = monkeys.iterator();//ģ��ѭ������  ��ͷ��ʼ  ��ͷ��ʼ û�п� ��� ����number���ü�1
			}
			//ɾ��Ӧ��ɾ���ĺ���
			if(number == 14){//Լɪ��  ����������14  ������� �������ⶨ
				number = 0;
				it.remove();//��������ɾ��
				cnt --;
			
			}
		}
		
		System.out.println(monkeys.element());//element()�ҵ������Ƴ����б��ͷ����һ��Ԫ�أ��� 
	}

}
