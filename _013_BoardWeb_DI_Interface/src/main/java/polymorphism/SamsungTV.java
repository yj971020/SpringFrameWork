package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;	

	public SamsungTV() {
		System.out.println("====> SamsungTV ��ü(1) ����");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("====> SamsungTV ��ü(2) ����");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("====> SamsungTV ��ü(3) ����");
		this.speaker = speaker;
		this.price = price;
	}

	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��...");
	}
	
	public void destroyMethod() {
		System.out.println("��ü ������ ó���� ����...");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�. (���� : " + price + ")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
	
	public void volumeUp() {
		/* speaker = new SonySpeaker(); */
		speaker.volumeUp();
//		System.out.println("SamsungTV---�Ҹ� �ø���.");
	}
	
	public void volumeDown() {
		/* speaker = new SonySpeaker(); */
		/* speaker = new AppleSpeaker(); */
		speaker.volumeDown();
//		System.out.println("SamsungTV---�Ҹ� ������.");
	}
}
