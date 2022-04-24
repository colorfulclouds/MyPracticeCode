

public class people implements Comparable{

	private Integer num;
	private String str;
	
	
	public people(Integer num, String str) {
		super();
		this.num = num;
		this.str = str;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		people other = (people) obj;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}

	public String toString() {
		return "people [num=" + num + ", str=" + str + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		people p = (people)o;
		if(this.num != p.num)
			return this.num.compareTo(p.num);
		else
			return this.str.compareTo(p.str);
//		return 0;
	}
	
}
