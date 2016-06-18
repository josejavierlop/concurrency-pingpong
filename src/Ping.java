
public class Ping implements Runnable{

	PingPong p;
	public Ping(PingPong p){
		this.p = p;
	}
	@Override
	public void run() {
		while(true){
			try {
				p.ping();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
