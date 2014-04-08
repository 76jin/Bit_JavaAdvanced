package basic.exam06.episode.up4;

import java.util.ArrayList;

// Java는 다중 상속을 지원하지 않는다.
//	- ArrayList를 상속받으면서 AbstractCollection을 상속받을 수 없다.
public class Collection5 
	extends ArrayList<Object> /*, AbstractCollection */ 
	implements Collection {
	
	// 문제 발생!
	// ArrayList로부터 상속받은 boolean add(Object value)와
	// Collection의 void add(Object value)가 시그너처가 같지 않다.
	// 	=> 컴파일 오류 발생
	// 해결책: Collection6 참조!
	
	@Override
  public boolean add(Object value) {
  }

	@Override
  public void insert(int index, Object value) {
  }


}
