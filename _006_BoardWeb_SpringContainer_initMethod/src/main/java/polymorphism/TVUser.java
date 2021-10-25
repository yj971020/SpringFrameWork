package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
	//1. Spring 컨테이너를 구동한다.
		//내가 만든 applicationContext.xml 파일을 읽어서 구동할 수 있도록 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

	//2. Spring 컨테이너 들로 부터 필요한 객체를 요청(LookUP) 한다
//		TV tv = (TV)factory.getBean("tv");
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
	//3. Spring 컨테이너를 종료한다.
		factory.close();
	}

}
