package basic.step01;

/*
 * \b	Backspace
 * \t	Tab
 * \n	line feed
 * \f	form feed
 * \r	carriage return
 * \"	double quote
 * \'	single quote
 * \\ backslash
 */

public class Variable05 {

	public static void main(String[] args) {
		char 제어문자1 = '\b';
		char 제어문자2 = '\t';
		char 제어문자3 = '\n';
		char 제어문자4 = '\f';
		char 제어문자5 = '\r';
		char 제어문자6 = '\"';
		char 제어문자7 = '\'';
		char 제어문자8 = '\\';

		System.out.println("Backspace : ABC" + 제어문자1 + "DEF");
		System.out.println("Horizontal TAB : ABC" + 제어문자2 + "DEF");
		System.out.println("Line Feed : ABC" + 제어문자3 + "DEF");
		System.out.println("Form Feed : ABC" + 제어문자4 + "DEF");
		System.out.println("Carriage Return : ABC" + 제어문자5 + "DEF");
		System.out.println("double quote : ABC" + 제어문자6 + "DEF");
		System.out.println("single quote : ABC" + 제어문자7 + "DEF");
		System.out.println("backslash : ABC" + 제어문자8 + "DEF");
	}

}
