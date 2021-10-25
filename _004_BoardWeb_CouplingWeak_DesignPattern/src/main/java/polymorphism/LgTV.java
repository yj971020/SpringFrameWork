package polymorphism;

public class LgTV implements TV{

	public void powerOn() {
		System.out.println("LgTV--전원켠다");
	}
	public void powerOff() {
		System.out.println("LgTV--전원끈다");
	}
	public void volumeUp() {
		System.out.println("LgTV--소리업 ");
	}
	public void volumeDown() {
		System.out.println("LgTV--소리 다운");
	}

}
