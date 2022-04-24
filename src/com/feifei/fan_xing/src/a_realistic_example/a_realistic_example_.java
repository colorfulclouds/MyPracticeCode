package a_realistic_example;

import java.util.HashMap;
import java.util.List;

public class a_realistic_example_ {

	public static void main(String[] args) {
		DAO<User> dao = new DAO<User>();
		
		dao.map = new HashMap<String,User>();
		
		dao.save("04133023", new User(1,20,"yufeifei"));
		dao.save("04133024", new User(2,21,"wangxin"));
		dao.save("04133025", new User(7,19,"tianzhao"));
		dao.save("04133026", new User(5,18,"lijing"));
		
		User u = dao.get("04133023");
		System.out.println(u);
		
		dao.update("04133023", new User(2,21,"feifeilvelve"));
		
		List<User> list = dao.list();
		System.out.println(list);
	}
}
