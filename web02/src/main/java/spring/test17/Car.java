package spring.test17;

import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/* @Autowired를 셋터 메서드가 아닌 인스턴스에 붙일 수 있다.
 * - 다만 여기 붙일 때는 유연성이 떨어진다.
 * - 코드 중간에 검증 처리 불가.
 * - 그래서 셋터/갯터 메서드가 간단하면 이렇게 처리하기도 함.
 * - 셋터 따로 만들면 중간에 검증 처리가 가능함.
 */
public class Car {
	String	model;
	@Autowired 
	@Qualifier("engine2")
	Engine	engine;
	Tire[]	tires;
	Map<String,Object> options;
	
	public Car() {}

	public Car(String model) {
	  this.model = model;
  }	
	
	public Car(String model, Engine engine) {
		this(model);	// 기존의 생성자 호출 (생성자만이 생성자 호출 가능)
		this.engine = engine;
	}
	
	@Override
  public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[자동차:" + model + ",\n");
		
		if (engine != null) {
			buf.append("   " + engine.toString() + ",\n");
		}
		
		if (tires != null) {
			for (Tire t : tires) {
				buf.append("   " + t.toString() + "\n");
			}
		}
		
		if (options != null) {
			for (Entry<String,Object> entry : options.entrySet()) {
				buf.append("   >" + entry.getKey() + ":"
													+ entry.getValue().toString() + "\n");
			}
		}
		
	  return buf.toString();
  }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public Engine getEngine() {
	  return engine;
  }

	public Tire[] getTires() {
		return tires;
	}

	public void setTires(Tire[] tires) {
		this.tires = tires;
	}

	public Map<String, Object> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}
	
	
	
	
}
