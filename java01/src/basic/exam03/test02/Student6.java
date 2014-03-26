package basic.exam03.test02;

// * finalize() 재정의
//	- garbage collector가 소멸시키기 전에 호출한다.
//	- 소멸되기 전에 마무리 할 작업을 기술할 수 있다.
//	- C++ 언어에서는 destructor(소멸자)라 부른다.
//	- 자바에서는 잘 사용하지 않는다. <= 언제 소멸될지 모른다. <= 종료하는 순간까지 소멸되지 않을 수 있다.
//	* Garbage Collector 호출 시점
//	1) 메모리 부족
//	2) CPU 한가할 때
//	==> 프로그램 종류 시까지 실행되지 않을 수도 있다.(거의 실행 안됨)
public class Student6 /* extends Object */ {
	// 모든 클래스는 클래스 정보를 다루는 숨겨진 변수를 가지고 있다.
/* public static Class class = Student5의 클래스 정보를 담은 인스턴스 */
	String 	name;
	int 		kor;
	int			math;
	int			eng;
	
	public Student6(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor	= kor;
		this.math	= math;
		this.eng	= eng;
	}

	
	
	@Override
  protected void finalize() throws Throwable {
		System.out.println("finalize()...");
  }



	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + eng;
	  result = prime * result + kor;
	  result = prime * result + math;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  return result;
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Student6 other = (Student6) obj;
	  if (eng != other.eng)
		  return false;
	  if (kor != other.kor)
		  return false;
	  if (math != other.math)
		  return false;
	  if (name == null) {
		  if (other.name != null)
			  return false;
	  } else if (!name.equals(other.name))
		  return false;
	  return true;
  }

	@Override
	public String toString() {
	  // TODO Auto-generated method stub
	  return "[" + this.name + ":" + this.kor + "," + this.eng + "," + this.math + "]";
	}

	
}
