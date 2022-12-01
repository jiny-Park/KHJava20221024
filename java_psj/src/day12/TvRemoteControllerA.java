package day12;

public class TvRemoteControllerA implements TvRemoteController {
	
	//
	private int channel;
	private int volumn;
	private boolean power;
	

	@Override
	public void turn() {
		//power가 켜져 있으면 꺼야하고, 꺼져 있으면 켜야 함
		power = !power;		// (현재 상태의 반대가 되야함)
	}

	@Override
	public void channel(int channel) {
		if(!power) {
			return;
		}
		this.channel = channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void channelUp() {
		if(!power) {
			return;
		}
		channel++;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void channelDown() {
		if(!power) {
			return;
		}
		channel--;
		channel = channel < 0 ? 999 : channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void volumnUp() {
		if(!power) {
			return;
		}
		volumn++;
		volumn = volumn > 30 ? 30 : volumn;
		System.out.println("볼륨 : " + volumn);
	}

	@Override
	public void volumnDown() {
		if(!power) {
			return;
		}
		volumn--;
		volumn = volumn < 0 ? 0 : volumn;
		System.out.println("볼륨 : " + volumn);
	}
	
	public void print() {
		System.out.println("전원 : " + (power ? "ON" : "OFF"));
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volumn);
		
	}

}
