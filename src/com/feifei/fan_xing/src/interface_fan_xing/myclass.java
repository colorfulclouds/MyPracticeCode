package interface_fan_xing;

 class myclass <T extends Comparable<T>> implements minmax{

	 T [] vals;
	 
	 myclass(T [] vals){
		 this.vals = vals;
	 }
	 
	public T min() {
		
		T val = vals[0];
		for(int i = 1;i<vals.length;i++)
			if(vals[i].compareTo(val) < 0)
				val = vals[i];
		return val;
	}

	public T max() {
		T val = vals[0];
		for(int i = 1;i<vals.length;i++)
			if(vals[i].compareTo(val) > 0)
				val = vals[i];
		return val;
		
	}

	
}
