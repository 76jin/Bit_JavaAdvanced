package test.step01.exam04.step06;

public class StudentScore {
	String name;
	int kor;
	int eng;
	int math;
	
	public StudentScore(String name) {
		this.name = name;
	}
	
	public static StudentScore fromCSV(String value) {
		String[] data = value.split(",");
		
	  StudentScore obj = new StudentScore(data[0]);
	  obj.kor = Integer.parseInt(data[1]);
	  obj.eng = Integer.parseInt(data[2]);
	  obj.math = Integer.parseInt(data[3]);
	  
	  return obj;
	}

	@Override
  public String toString() {
	  return name + "," + kor + "," + eng + "," + math;
  }
	
}
