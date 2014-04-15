package basic.exam06.jdbc.up4;

import java.lang.reflect.Method;

public class Episode01 {

	public static void main(String[] args) throws Exception {
			// C:> java Hello aaa bbb ccc
			// args[0] -> "aaa"
			// args[1] -> "bbb"
			// args[2] -> "ccc"
			// C:> java SubjectMgt2 basic.exam06.jdbc.up4.MysqlSubjectDao
			// args[0] -> "basic.exam06.jdbc.up4.MysqlSubjectDao"
			
			//String subjectDaoClassName = args[0];
			
			// 클래스 이름만 알면 클래스를 로딩할 수 있다.
			// Class.forName(패키지명+클래스명);
			//    => 로딩된 클래스 정보를 다루는 객체를 리턴(java.lang.Class)
			//Class clazz = Class.forName(subjectDaoClassName);
			
			Class clazz = Class.forName("basic.exam06.jdbc.up4.MysqlSubjectDao");
			
			for (Method method : clazz.getMethods() ) {
				System.out.println("-->" + method.getName());
			}
	}

}
