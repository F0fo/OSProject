public class Consumer extends Thread {
	public Consumer() {

	}

	@Override
	public void run() {
		try {
			App.full.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			App.entry.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int z = 0;

		for (int i = 0; i < 4096; i+=8) {
			if ((App.x[i].equals("O"))&&
					(App.x[i+1].equals("s"))&&
					(App.x[i+2].equals("I"))&&
					(App.x[i+3].equals("s"))&&
					(App.x[i+4].equals("F"))&&
					(App.x[i+5].equals("u"))&&
					(App.x[i+6].equals("n"))) {
				App.x[i] = "f";
				App.x[i+1] = "r";
				App.x[i+2] = "e";
				App.x[i+3] = "e";
				App.x[i+4] = "e";
				App.x[i+5] = "e";
				App.x[i+6] = "e";				 try { 
					 Thread.sleep(1000);
				 } catch (Exception e) { 
					 // TODO Auto-generated catch
					  e.printStackTrace();
					  }
				App.empty.release();
				App.entry.release();
				System.out.println("34");
			}

		}
		for (String x : App.x) {

			System.out.println(App.x[z]);
			z++;

		}

	}

	/**
	 
	 **/
}
