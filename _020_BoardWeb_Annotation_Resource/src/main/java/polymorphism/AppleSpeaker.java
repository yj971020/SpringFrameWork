package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("====> ���� ����Ŀ ��ü ����");
	}
	public void volumeUp() {
		System.out.println("���� ����Ŀ---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("���� ����Ŀ---�Ҹ� ������.");
	}
}
