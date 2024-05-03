public class Producer extends Thread {

	public Producer() {
		for (int i = 0; i < 4096; i+=8) {
			App.x[i] = "f";
			App.x[i+1] = "r";
			App.x[i+2] = "e";
			App.x[i+3] = "e";
			App.x[i+4] = "e";
			App.x[i+5] = "e";
			App.x[i+6] = "e";
			App.x[i+7] = "\0";
			}
	}

	@Override
	public void run() {
		int i = ((int) (Math.random() * 511))*8;
		try {
			App.empty.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			App.entry.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((App.x[i].equals("f"))&&
				(App.x[i+1].equals("r"))&&
				(App.x[i+2].equals("e"))&&
				(App.x[i+3].equals("e"))&&
				(App.x[i+4].equals("e"))&&
				(App.x[i+5].equals("e"))&&
				(App.x[i+6].equals("e"))) {
			App.x[i] = "O";
			App.x[i+1] = "s";
			App.x[i+2] = "I";
			App.x[i+3] = "s";
			App.x[i+4] = "F";
			App.x[i+5] = "u";
			App.x[i+6] = "n";

		}
		App.full.release();
		App.entry.release();
		int z = 0;
		for (String x : App.x) {

			System.out.println(App.x[z]);
			z++;

		}

	}

}
