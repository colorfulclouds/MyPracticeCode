package priorityqueue;
//���ȶ���  ���ȶ���
public class job {

	private int number;//��ҵ���
	private int spend;//��ҵ����ʱ��
	
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
