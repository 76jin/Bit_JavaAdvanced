package basic.exam06.jdbc.up2;

import java.util.Scanner;


/* SubjectDao 사용 */
public class DeleteTest {

	public static void main(String[] args) throws Throwable {
		
		SubjectDao dao = new SubjectDao();
		Scanner scanner = new Scanner(System.in);
		
		dao.delete( Integer.parseInt(scanner.nextLine()) );
		
		System.out.println("삭제 성공!");
		
		scanner.close();
	}

}
