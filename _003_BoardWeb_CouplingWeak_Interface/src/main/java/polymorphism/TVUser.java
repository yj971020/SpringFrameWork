package polymorphism;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new SamsungTV();
		//TV tv =new LgTV(); 
		// �����ϴ� ��ü�� �����ص� ��
		//but user �� �ǵ�����ϴ� ������ ������
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
