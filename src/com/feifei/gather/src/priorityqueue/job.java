package priorityqueue;
//优先队列  优先队列
public class job {

	private int number;//作业编号
	private int spend;//作业所需时间
	
	public job(int number,int spend){
		this.number = number;
		this.spend = spend;
	}
	
	public int getnumber(){
		return number;
	}
	
	public void setnumber(int number){
		this.number = number;
	}
	
	public int getspend(){
		return spend;
	}
	
	public void setspend(int spend){
		this.spend = spend;
	}
}
