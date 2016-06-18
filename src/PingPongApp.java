import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongApp {
	public static void main(String[] args) throws InterruptedException{
		ExecutorService executor = Executors.newFixedThreadPool(50);
		PingPong p = new PingPong();
		
		for(int i = 0; i < 100; i++){
			executor.execute(new Ping(p));
			executor.execute(new Pong(p));
		}
		executor.shutdown();
		while(!executor.isTerminated()){
			Thread.sleep(1000);
		}
	}
}
