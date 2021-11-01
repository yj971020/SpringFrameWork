package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;	

	public SamsungTV() {
		System.out.println("====> SamsungTV ��ü(1) ����");
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("====> setSpeaker() ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("====> setPrice() ȣ��");
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
