package basic.step03;

public class Control04 {

	public static void main(String[] args) {
	/*
		for (int index = 0; index < 10; index++)
			System.out.println("index = " + index);
	 */
/*		
		int index = 0;
		for ( ; index < 10; index++ )
			System.out.println("index = " + index);
		System.out.println("index = " + index);
*/
/*		
		int index = 0;
		for ( ; index < 10; ) {
			System.out.println("index = " + index);
			index++;
		}
		
		System.out.println("마지막 index 값 = " + index);
*/
/*
		int index = 0;
		for ( ; ; ) {
			if (index >= 10)
				break;
			
			System.out.println("index = " + index);
			index++;
		}
		System.out.println("index = " + index);
*/
/*		
		AAA:
		{
			for (int i=1; i < 10; i++) {
				System.out.println("구구단 " + i + " 단");
				for (int j=1; j < 10; j++) {
					if(i > 5)
						break AAA;
					
					System.out.println(i + " * " + j + " = " + i * j);
				}
			}
			
			System.out.println("반복문 끝");
		}
	
		System.out.println("끝");
*/	
/*		
		for (int i=0; i < 9; i++) {
			if (i == 5)
				continue;
			
			System.out.println("i = " + i);
		}
		
*/
		AAA:
			for(int i = 1; i < 10; i++) {
				for(int j = 1; j < 10; j++) {
					if(j == 5)
						continue AAA;
					System.out.println(i + " * " + j + " = " + i * j);;
				}
				System.out.println("*************************************");
			}	
	}

}
