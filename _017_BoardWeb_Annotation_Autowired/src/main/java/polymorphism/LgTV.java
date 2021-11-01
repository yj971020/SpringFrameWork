package polymorphism;

import org.springframework.stereotype.Component;

@Component//==> id�� name ������ �� lgTV �ڵ����� �̸��� ������
//<bean class="polymorphism.LgTV></bean>
//@Component("tv")
//<bean id="tv" class="polymorphism.LgTV></bean>
public class LgTV implements TV {
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	
	public void volumeUp() {
		System.out.println("LgTV---�Ҹ� �ø���.");
	}
	
	public void volumeDown() {
		System.out.println("LgTV---�Ҹ� ������.");
	}
}
