import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class pro {
	
	/*��ͺ��� ����List���͵�para������Ԫ��֮��*/
	public static int get_sum(List<Integer> para)
	{
		int sum=0;
		
		for(int i=0;i<para.size();i++)
		{
			sum += para.get(i);
		}
		
		return sum; 
	}
	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //n������ʾ��
		
		int people; //ÿһ�����������ж��ٸ���
	

		List<Integer> scores = new ArrayList<Integer>(); //��������ÿһ������ʾ���е� ÿһ��people�ķ���
		List<Integer> jiang = new ArrayList<Integer>(); //��������ÿһ������ʾ���е� ÿһ��people�Ľ�Ʒ��
		
		List<Integer> result = new ArrayList<Integer>(); //��������ÿһ���������������ս�� ��ÿһ������������������Ҫ׼���Ľ�Ʒ��
		
		for(int i=0;i<n;i++) //n����������
		{
			scores.clear(); //��� ÿ��ʹ��֮ǰ���
			jiang.clear(); //��� ÿ��ʹ��֮ǰ���
			
			people = sc.nextInt(); //����һ������ʾ���е�����
			
			for(int j=0;j<people;j++)
			{
				scores.add( sc.nextInt() ); //����һ������������ÿ���˵ķ���
				jiang.add(1); //ÿ���˳�ʼ��ʱ�� ��Ʒ��Ϊ1
			}
			//TODO
			
			//ͼƬ�е�Ȧ1����
			int last=scores.get( scores.size()-1 ); //���һ��Ԫ��
			int first=scores.get(0); //��һ��Ԫ��
			scores.add(0 ,  last); //����ǰ���һ�����һ��Ԫ��
			scores.add(first); //��������һ����һ��Ԫ��
			
			//ͼƬ�е�ͼ2����
			jiang.add(0,1);
			jiang.add(1);
			
			for(int k=1;k<scores.size()-1;k++)
			{
				//��scores���±�Ϊ1����ʼ
				if(scores.get(k)>scores.get(k-1) && scores.get(k) > scores.get(k+1))
				{
					/*
					 * ��ǰ�˵ķ���������˺��ұ��˵ķ�������
					 * �򽫵�ǰ�˵Ľ�Ʒ��������Ϊ�������˽ϸ߽�Ʒ����+1
					 * */
					
					
					if( jiang.get(k-1) > jiang.get(k+1) )
					{
						/*
						 * �������˱��ұ��˽�Ʒ������
						 * */
						jiang.set(k, jiang.get(k-1) + 1); //��ǰ�˵Ľ�Ʒ������������˽�Ʒ��+1
					}
					else if(jiang.get(k-1) <= jiang.get(k+1))
					{
						/*
						 * ����ұ��˱�����˽�Ʒ������
						 * */
						jiang.set(k, jiang.get(k+1) + 1); ////��ǰ�˵Ľ�Ʒ���������ұ��˽�Ʒ��+1
					}
					
					if(k==1)
					{
						/*
						 * ������±�Ϊ1��λ�õ�ʱ�� �����±�Ϊ1���˵Ľ�Ʒ�����������޸� ����Ҫ��jiang�����һ��Ԫ��ͬ�������޸ģ����⣩
						 * */
						jiang.set(jiang.size()-1 , jiang.get(1) );
					}
					
					continue; //����������һ����
				}
				/*
				if(scores.get(k)>scores.get(k-1))
				{
					//
					 // ��ǰ�˵ķ���������˵ķ�����
					 // �򽫵�ǰ�˵Ľ�Ʒ��������Ϊ����˽�Ʒ����+1
					 //
					jiang.set(k, jiang.get(k-1) + 1);
					
					if(k==1)
					{
						//ͬ86��
						jiang.set(jiang.size()-1 , jiang.get(1) );
					}
				}
				if(scores.get(k)>scores.get(k+1))
				{
					//
					 // ��ǰ�˵ķ������ұ��˵ķ�����
					 // �򽫵�ǰ�˵Ľ�Ʒ��������Ϊ�ұ��˽�Ʒ����+1
					  //
					jiang.set(k, jiang.get(k+1) + 1);
					
					if(k==1)
					{
						//ͬ86��
						jiang.set(jiang.size()-1 , jiang.get(1) );
					}
				}*/
			}
			
			result.add(get_sum(jiang) -1 -jiang.get( jiang.size()-1 )); //��jiang�е�Ԫ����Ͳ���ȥ�ײ���ĩβ���ظ�Ԫ�� ����Ʒ��������
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println(result.get(i)); //���
		}
	}
}
/*
 * ���
 * �������ܵ����ʱ��
 * ��Ϊ�������
 * */
