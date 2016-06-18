import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean ping = true;
	
	public void ping() throws InterruptedException{
		try{
		lock.lock();
		while(!ping){
			condition.await();
		}
		ping = false;
		System.out.print("ping-");

		condition.signal();
		}finally{
			lock.unlock();
		}
	}
	public void pong() throws InterruptedException{
		try{
		lock.lock();
		while(ping){
			condition.await();
		}
		ping = true;
		System.out.print("pong-");

		condition.signal();
		}finally{
			lock.unlock();
		}
	}
}
