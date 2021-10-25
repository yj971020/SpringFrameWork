package polymorphism;

public class SamsungTV implements TV{
	//생성자 추가
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리...");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV--전원켠다");
	}
	public void powerOff() {
		System.out.println("SamsungTV--전원끈다");
	}
	public void volumeUp() {
		System.out.println("SamsungTV--소리업 ");
	}
	public void volumeDown() {
		System.out.println("SamsungTV--소리 다운");
	}

}
