package question1;

import java.math.*;
class point{
	
	double x;
	double y;
	
	public point(double x,double y) {

		this.x = x;
		this.y = y;
	}
	
}

class line{
	
	point p1;
	point p2;
	
	public line(point p1,point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	double length(){
		
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		
	}
	
}

public class answer1 {

	public static void main(String[] args) {

		point p1 = new point(0, 0);
		point p2 = new point(8, 2);
		point p3 = new point(4, 8);
		
		line line1 = new line(p1, p2);
		line line2 = new line(p1, p3);
		line line3 = new line(p3, p2);
		
		double length1 = line1.length();
		double length2 = line2.length();
		double length3 = line3.length();
		
		System.out.println(length1+" "+length2+" "+length3);
		
		double p = (length1+length2+length3)/2.0;
		
		System.out.println(Math.sqrt(p*(p-length1)*(p-length2)*(p-length3)));
		
	}

}
