package basic.exam06.episode;

public class Test {
	static Collection2 coll = new Collection2(2);
	
	public static void testAdd() throws Exception {
		coll.add("홍길동");
		coll.add("임꺽정");
		coll.add("장길산");
	}
	
	public static void testList() throws Exception {
		for (int i=0; i < coll.size(); i++) {
			System.out.println(coll.get(i));
		}
	}
	
	public static void main(String[] args) {
		try {
			testAdd();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			testList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
