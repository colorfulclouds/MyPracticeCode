package class_tongpeifu_fan_xing;


public class stats<T extends Number> {

	T [] nums;
	
	public stats(T [] nums){
		this.nums = nums;
	}
	
	public double average(){
		double sum = 0.0;
		for(int i = 0;i<nums.length;i++)
			sum += nums[i].doubleValue();
		return sum/nums.length;
	}
	
	public void dosomething(stats <?> ob){
		System.out.println(ob.getClass().getName());
	}
}
