package test.step01.exam04.step06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import basic.exam03.test02.Student;

public class Episode01 {
	
	public static void main(String[] args) {
		class MyKey {
			int keyNo;
			
			public MyKey(int no) {
				this.keyNo = no;
			}

			@Override
      public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + keyNo;
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
	      MyKey other = (MyKey) obj;
	      if (keyNo != other.keyNo)
		      return false;
	      return true;
      }
			
		}
		
		MyKey k1 = new MyKey(100);
		
		HashMap<MyKey,String> map = new HashMap<MyKey,String>();
		map.put(k1, "홍길동");
		
		MyKey k2 = new MyKey(100);

		if (k1 == k2 ) System.out.println("인스턴스 같다");
		if (k1.equals(k2) ) System.out.println("equals..ok");
		if (k1.hashCode() == k2.hashCode() ) System.out.println("hasCode..ok");

		System.out.println( map.get(k2) );
		
	}
	
	public static void main06(String[] args) {
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(new Integer(100),"홍길동");
		map.put(200, "임꺽정");
		map.put(300, "장국영");
		map.put(400, "홍길동");
		
		map.put(400,  "오호라");
		
		System.out.println( map.get(100) );
		System.out.println( map.get(200) );
		System.out.println( map.get(300) );
		System.out.println( map.get(new Integer(400)) );
		
		System.out.println("-------------------");
		for (String name : map.values())
			System.out.println(name);
		
		System.out.println("-------------------");
		for (Integer key : map.keySet())
			System.out.println(key);
	}

	public static void main05(String[] args) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("100","홍길동");
		map.put("200", "임꺽정");
		map.put("300", "장국영");
		map.put("400", "홍길동");
		
		map.put("400",  "오호라");
		
		System.out.println( map.get("100") );
		System.out.println( map.get("200") );
		System.out.println( map.get("300") );
		System.out.println( map.get("400") );
		
		System.out.println("-------------------");
		for (String name : map.values())
			System.out.println(name);
		
		System.out.println("-------------------");
		for (String key : map.keySet())
			System.out.println(key);
	}
	
	public static void main04(String[] args) {

		class Student {
			String name;
			int age;

			public Student(String n, int age) {
				name = n;
				this.age = age;
			}

			public String toString() {
				return name + "," + age;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + age;
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
				Student other = (Student) obj;
				if (age != other.age)
					return false;
				if (name == null) {
					if (other.name != null)
						return false;
				} else if (!name.equals(other.name))
					return false;
				return true;
			}

		}

		Student s1 = new Student("홍길동", 18);
		Student s2 = new Student("임꺽정", 20);
		Student s3 = new Student("장국영", 30);
		Student s4 = new Student("홍길동", 18);

		if (s1 == s4) System.out.println("s1 == s4");
		if (s1.equals(s4)) System.out.println("s1.equals(s4)");
		if (s1.hashCode() == s4.hashCode()) System.out.println("hashCode..ok");

		// HashSet의 사용2
		HashSet<Student> list = new HashSet<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		for (Student name : list)
			System.out.println(name);
	}
	
	public static void main03(String[] args) {
		
		class Student {
			String name;
			int age;
			
			public Student(String n, int age) {
				name = n;
				this.age = age;
			}
			
			public String toString() {
				return name + "," + age;
			}
		}
		
		// HashSet의 사용2
		HashSet<Student> list = new HashSet<Student>();
		list.add(new Student("홍길동", 18));
		list.add(new Student("임꺽정", 20));
		list.add(new Student("장국영", 30));
		list.add(new Student("홍길동", 18));
		
		for (Student name : list)
			System.out.println(name);
	}
	
	public static void main02(String[] args) {
		// HashSet의 사용
		HashSet<String> list = new HashSet<String>();
		list.add("홍길동");
		list.add("임꺽정");
		list.add("장국영");
		list.add("홍길동");
		
		for (String name : list)
			System.out.println(name);
	}

	public static void main01(String[] args) {
		// ArrayList의 사용
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("임꺽정");
		list.add("장국영");
		list.add("홍길동");
		
		for (String name : list)
			System.out.println(name);
	}

}
