package spring.test19;

import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.config.AbstractFactoryBean;

// 스프링 팩토리 빈 만들기
//  - 기존과 다르게 팩토리 메서드의 파라미터 값을 받을 수 없다.
// .class : class의 숨겨진 변수, 클래스의 정보를 가지고 있음.

// 1. FactoryBean 인터페이스 구현
//	 - 인터페이스에 선언된 모든 메서드를 정의해야 한다.
//
// 2. AbstractFactoryBean 추상클래스를 상속받는다.
//	 - getObjectType()과 createInstance() 재정의한다.
//
public class TireFactoryBean extends AbstractFactoryBean<Tire> {
	
	int prodId;
	
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	@Override
	public Class<?> getObjectType() {
	  return Tire.class;
	}
	
	public Tire createInstance() {
		
		Tire tire = null;
		Properties spec = new Properties();
	
		if (prodId == 100) { // 한국타이어-승용차-일반
			tire = new Tire("한국타이어");
			tire.setCreatedDate(new Date());
			
			spec.put("width", 215);
			spec.put("ratio", 65);
			spec.put("rim.diameter", 12);
			tire.setSpec(spec);
			
		} else if (prodId == 101) { // 한국타이어-승용차-스포티
			tire = new Tire("한국타이어");
			tire.setCreatedDate(new Date());
			
			spec.put("width", 115);
			spec.put("ratio", 25);
			spec.put("rim.diameter", 22);
			tire.setSpec(spec);
		} else if (prodId == 200) { // 금호타이어-승용차-일반
			tire = new Tire("금호타이어");
			tire.setCreatedDate(new Date());
			
			spec.put("width", 225);
			spec.put("ratio", 55);
			spec.put("rim.diameter", 13);
			tire.setSpec(spec);
		} else if (prodId == 201) { // 금호타이어-승용차-스노우
			tire = new Tire("금호타이어");
			tire.setCreatedDate(new Date());
			
			spec.put("width", 235);
			spec.put("ratio", 45);
			spec.put("rim.diameter", 17);
			tire.setSpec(spec);
			
		} else { // 일반 막 타이어
			tire = new Tire("재생타이어");
			tire.setCreatedDate(new Date());
			
			spec.put("width", 205);
			spec.put("ratio", 65);
			spec.put("rim.diameter", 15);
			tire.setSpec(spec);
			
		}
		
		return tire;
	}
	
}
