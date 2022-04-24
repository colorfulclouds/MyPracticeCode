package class_youjie_fan_xing;


class _stats<T extends Number>{
	
	T [] nums;
	public _stats(T [] nums) {

		this.nums = nums;
	}
	
	double average(){
		double sum = 0.0;
		for(int i = 0;i<nums.length;i++)
			sum += nums[i].doubleValue();
		return sum/nums.length;
	}

	
}
public class _class_youjie_fan_xing {
	
	public static void main(String [] args){
		
		Integer [] inums = {1,2,3,4,5,6};
		_stats<Integer> iobj = new _stats(inums);//stats<Integer> iobj = new stats<Integer>(inums);ТаїЙ
		
		Float [] iinums = {1.2f,2.1f,6.5f,8.4f};
		_stats<Float> iiobj = new _stats<Float>(iinums);
		System.out.println("");
		//System.out.println(iobj.average());
	}

}
