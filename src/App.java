import java.util.concurrent.Semaphore;

public class App {
	public static Semaphore entry = new Semaphore(1);
	public static Semaphore empty = new Semaphore(512);
	public static Semaphore full = new Semaphore(0);
	public static String[] x = new String[4096];

	public static void semWait(int s) {
		while (s == 0) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}  
			s--;
		

	}

	public static void semSignal(int s) {
		s++;
	}

	public static void main(String[] args) {
		Producer Produce = new Producer();
		Consumer Consume = new Consumer();

		while (true) {
			Produce.run();
			Consume.run();

		}

	}
}
