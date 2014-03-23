package basic.step01;

public class Variable02 {

	public static void main(String[] args) {
		boolean 관계1 = 4 > 5;		// false
		boolean 관계2 = !false;	// true
		boolean 관계3 = (4 > 5) == false; //true
		
//	boolean 관계4 = 1; // cannot convert from int to boolean
		
		System.out.println(관계1);
		System.out.println(관계2);
		System.out.println(관계3);

	}

}
