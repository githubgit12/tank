package TK;

public class Main {
	public static void main(String[] args) {

		TanKeFrame tanKe = new TanKeFrame();
		//初始化敌方坦克
		for (int i = 0; i <5 ; i++) {
			tanKe.tankes.add(new Tanke(50+i*80,200,Dir.DOWN,tanKe));
		}

		while (true) {
			try {
				Thread.sleep(50);
				tanKe.repaint();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
}
