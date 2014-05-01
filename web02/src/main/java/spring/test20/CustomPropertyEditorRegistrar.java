package spring.test20;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditorRegistrar 
	implements PropertyEditorRegistrar {
	
	CustomDateEditor customDateEditor;
	
	public void setCustomDateEditor(CustomDateEditor customDateEditor) {
		this.customDateEditor = customDateEditor;
	}
	

	// 메서드 호출 순서
	// 1) 스프링 IoC 컨테이너가 beans.xml 파일을 읽는다.
	// 2) 빈을 생성한다.
	// 3) CustomEditorConfigurer 객체가 있는지 찾는다 => 찾았으면!
	// 4) 커스텀 에디터 설정 장치가 갖고 있는 에디터 등록 장치를 실행한다.(개수만큼 반복)
	// 5) 커스텀 에디터 등록장치. registerCustomEditor(기록할 때 사용할 용지)
	// 6) registerCustomerEditors()에서는 '기록지'에 커스텀 에디터를 적는다!
	//    기록지: PropertyEditorRegistry

	// Spring IoC Container
	// 	=> CustomEditorConfigurar
	//		=> CustomPropertyEditorRegistrar.registerCustomEditors() 호출
	@Override
  public void registerCustomEditors(PropertyEditorRegistry registry) {
		// java.util.Date 객체에 customDateEditor를 사용하도록 하라.
		registry.registerCustomEditor(java.util.Date.class, customDateEditor);
  }

}
