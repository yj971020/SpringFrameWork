package polymorphism;

public class TVUser {
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumDown();
//		tv.powerOff();
//		
		
		//���յ��� ���� ���α׷� :�����ڰ� �����ϰ� �����ؾ��ϴ� ��ü���� �������� ���α׷� 
		LgTV tv = new LgTV();

		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
