import java.util.*;
import java.math.*;

public class jinzhitrans {
	
	public static int parseHex(String hexStr){//ʮ������תʮ����
		
		int sum = 0;
		int i = 0;
		//System.out.println(hexStr.length());
		char [] array = hexStr.toCharArray();
		//System.out.println(array.length);
		System.out.println("start");
		while(i<hexStr.length()){
			
			System.out.println(array[i]);
			
			switch(array[i]){
			case 'A':
				sum += (10*Math.pow(16, hexStr.length() - i -1));
				break;
			case 'B':
				sum += (11*Math.pow(16, hexStr.length() - i -1));
				break;
			case 'C':
				sum += (12*Math.pow(16, hexStr.length() - i -1));
				break;
			case 'D':
				sum += (13*Math.pow(16, hexStr.length() - i -1));
				break;
			case 'E':
				sum += (14*Math.pow(16, hexStr.length() - i -1));
				break;
			case 'F':
				sum += (15*Math.pow(16, hexStr.length() - i -1));
				break;
			default:
				System.out.println(((int)array[i] - 48) * Math.pow(16, hexStr.length() - i - 1));
				sum += ((int)array[i] - 48) * Math.pow(16, hexStr.length() - i - 1);
				System.out.println("sum"+sum);
			
			}
			i++;
		}
		return sum;
		
	}
	
	public static String convertDecimalToHex(int value){ //ʮ����תʮ������
		
		char [] array = {0,0,0,0,0,0,0};
		int i = 0;
		int temp_num;
		while(value != 0){
			temp_num = value%16;
			System.out.println((i+1)+"λ : "+temp_num);
			value /= 16;
			switch(temp_num){
			case 10:
				array[i] = 'A';
				break;
			case 11:
				array[i] = 'B';
				break;
			case 12:
				array[i] = 'C';
				break;
			case 13:
				array[i] = 'D';
				break;
			case 14:
				array[i] = 'E';
				break;
			case 15:
				array[i] = 'F';
				break;
				
				default:
					array[i] = (char) (temp_num + 48);
					
			}
			
			System.out.println("rr: "+array[i]);
			i++;
		}
	
		System.out.println("i"+i);
		for(int j = 0;j<i/2;j++){
			array[j] ^=array[i - 1 - j];
			array[i - 1 - j] ^=array[j];
			array[j] ^=array[i - 1 - j];
			
		}
		return new String(array);
	}
	
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		String hexStr ;
		int value;
		System.out.print("��һ��ʮ����������: ");
		hexStr = reader.next(); 
		System.out.println("ʮ������: "+hexStr+"  "+"ʮ����:"+parseHex(hexStr));
		
		System.out.print("��һ��ʮ�������� : ");
		value = reader.nextInt();
		System.out.println("ʮ����: "+value+"  "+"ʮ������:"+convertDecimalToHex(value));
	}

}
	

