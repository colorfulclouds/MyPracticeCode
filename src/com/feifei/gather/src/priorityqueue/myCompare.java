package priorityqueue;

public class myCompare implements Comparable<job>{//�ȽϵĶ�����job
	
	public int compare(job o1,job o2){
		if(o1.getspend() > o2.getspend())
			return 1;
		if(o1.getspend() < o2.getspend())
			return -1;
		return 0;
	}
	
	public boolean equals(Object obj){
		return super.equals(obj);
	}

	@Override
	public int compareTo(job o) {
		// TODO �Զ����ɵķ������
		return 0;
	}
}
