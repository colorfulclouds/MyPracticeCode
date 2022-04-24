import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



class test{

	static String str = "1234567890";
	
	public void change(){
		str = "123";	
		System.out.println(str);
		}
}

class test2{
	
	test t;
	
	public void change2(){
		test.str = "456";
		System.out.println(test.str);
	}
}


//这是一个配置文件的测试    配置文件中 不能有空格
public class test_Properties {

	public static void main(String[] args) throws Exception, IOException {
		
//		Properties p =new Properties();
//		p.load(new FileInputStream(new File("H:\\JAVA语言练习\\gather\\src\\test.properties")));
//		String str = p.getProperty("user");
//		System.out.println(str);
		
//		test t = new test();
		test2 tt = new test2();
		tt.change2();
	}
}
