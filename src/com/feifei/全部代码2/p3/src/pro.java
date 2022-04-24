import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class pro {
	
	/*求和函数 计算List类型的para的所有元素之和*/
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
		
		int n = sc.nextInt(); //n个输入示例
		
		int people; //每一个输入样例中多少个人
	

		List<Integer> scores = new ArrayList<Integer>(); //用来保存每一个输入示例中的 每一个people的分数
		List<Integer> jiang = new ArrayList<Integer>(); //用来保存每一个输入示例中的 每一个people的奖品数
		
		List<Integer> result = new ArrayList<Integer>(); //用来保存每一个输入样例的最终结果 即每一个输入样例的最少需要准备的奖品数
		
		for(int i=0;i<n;i++) //n个输入样例
		{
			scores.clear(); //清空 每次使用之前清空
			jiang.clear(); //清空 每次使用之前清空
			
			people = sc.nextInt(); //输入一个输入示例中的人数
			
			for(int j=0;j<people;j++)
			{
				scores.add( sc.nextInt() ); //输入一个输入样例中每个人的分数
				jiang.add(1); //每个人初始的时候 奖品数为1
			}
			//TODO
			
			//图片中的圈1操作
			int last=scores.get( scores.size()-1 ); //最后一个元素
			int first=scores.get(0); //第一个元素
			scores.add(0 ,  last); //在最前面放一个最后一个元素
			scores.add(first); //在最后面放一个第一个元素
			
			//图片中的图2操作
			jiang.add(0,1);
			jiang.add(1);
			
			for(int k=1;k<scores.size()-1;k++)
			{
				//从scores的下标为1处开始
				if(scores.get(k)>scores.get(k-1) && scores.get(k) > scores.get(k+1))
				{
					/*
					 * 当前人的分数比左边人和右边人的分数都高
					 * 则将当前人的奖品数量设置为左右两人较高奖品数量+1
					 * */
					
					
					if( jiang.get(k-1) > jiang.get(k+1) )
					{
						/*
						 * 如果左边人比右边人奖品数量多
						 * */
						jiang.set(k, jiang.get(k-1) + 1); //当前人的奖品数量等于左边人奖品数+1
					}
					else if(jiang.get(k-1) <= jiang.get(k+1))
					{
						/*
						 * 如果右边人比左边人奖品数量多
						 * */
						jiang.set(k, jiang.get(k+1) + 1); ////当前人的奖品数量等于右边人奖品数+1
					}
					
					if(k==1)
					{
						/*
						 * 如果在下标为1的位置的时候 即对下标为1的人的奖品数量进行了修改 则需要讲jiang的最后一个元素同样进行修改（讲解）
						 * */
						jiang.set(jiang.size()-1 , jiang.get(1) );
					}
					
					continue; //继续处理下一个人
				}
				/*
				if(scores.get(k)>scores.get(k-1))
				{
					//
					 // 当前人的分数比左边人的分数高
					 // 则将当前人的奖品数量设置为左边人奖品数量+1
					 //
					jiang.set(k, jiang.get(k-1) + 1);
					
					if(k==1)
					{
						//同86行
						jiang.set(jiang.size()-1 , jiang.get(1) );
					}
				}
				if(scores.get(k)>scores.get(k+1))
				{
					//
					 // 当前人的分数比右边人的分数高
					 // 则将当前人的奖品数量设置为右边人奖品数量+1
					  //
					jiang.set(k, jiang.get(k+1) + 1);
					
					if(k==1)
					{
						//同86行
						jiang.set(jiang.size()-1 , jiang.get(1) );
					}
				}*/
			}
			
			result.add(get_sum(jiang) -1 -jiang.get( jiang.size()-1 )); //讲jiang中的元素求和并减去首部和末尾的重复元素 即奖品的总数量
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println(result.get(i)); //输出
		}
	}
}
/*
 * 最后
 * 怀念上周的这个时候
 * 因为马上相见
 * */
