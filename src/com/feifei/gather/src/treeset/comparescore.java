package treeset;

import java.util.Comparator;

public class comparescore implements Comparator<_treeset>{
	public int compare(_treeset st1,_treeset st2){
		if(st1.getscore() < st2.getscore())
			return 1;
		if(st1.getscore() > st2.getscore())
			return -1;
		return 0;
	}
	
	public boolean equals(Object obj){
		return super.equals(obj);
	}

}
