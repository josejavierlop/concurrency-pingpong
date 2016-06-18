
public class Pong implements Runnable{

	PingPong p;
	public Pong(PingPong p){
		this.p = p;
	}
	@Override
	public void run() {
		while(true){
			try {
				p.pong();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
