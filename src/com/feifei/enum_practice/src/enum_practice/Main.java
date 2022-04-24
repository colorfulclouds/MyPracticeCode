package enum_practice;

interface info{
	void show();
}
public class Main {

	public static void main(String [] args){
		
		SEASON s = SEASON.SPRING;
		s.show();
		SEASON s1 = SEASON.valueOf("SUMMER");
		s1.show();
		SEASON [] s2 = SEASON.values();
		for(SEASON s3:s2)
			s3.show();
	}
	
	enum SEASON implements info{
		SPRING("chuntian"){

			public void show() {
				System.out.println("chuguliang");
			}
			
		},
		SUMMER("xiatian"){

			public void show() {
				System.out.println("xiagege");
			}
			
		};
		private final String  seasonname;
		
		private SEASON(String name){
			this.seasonname = name;
		}
	}
}
