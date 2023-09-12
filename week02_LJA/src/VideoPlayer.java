interface controllable{
	void play();
	void stop();
}


public class VideoPlayer {
	public static void main(String[] args) {
		controllable c = new controllable() {
			public void play() {
				System.out.println("PLAY");
			}
			public void stop() {
				System.out.println("STOP");
			}
		};
		c.play();
		c.stop();
	}
}
