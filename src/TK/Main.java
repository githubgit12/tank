package TK;

public class Main {
	public static void main(String[] args) {

		TanKeFrame tanKe = new TanKeFrame();

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
