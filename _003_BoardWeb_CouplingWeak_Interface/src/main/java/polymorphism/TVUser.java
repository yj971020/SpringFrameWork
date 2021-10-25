package polymorphism;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new SamsungTV();
		//TV tv =new LgTV(); 
		// 참조하는 객체만 변경해도 됨
		//but user 를 건드려야하는 불편함 존재함
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
