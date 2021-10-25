package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
	//1. Spring �����̳ʸ� �����Ѵ�.
		//���� ���� applicationContext.xml ������ �о ������ �� �ֵ��� 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

	//2. Spring �����̳� ��� ���� �ʿ��� ��ü�� ��û(LookUP) �Ѵ�
//		TV tv = (TV)factory.getBean("tv");
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
	//3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
	}

}
