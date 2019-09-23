package TK;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TanKeFrame extends Frame {

	Tanke myTanke = new Tanke(200, 200, Dir.DOWN);

	public TanKeFrame() {

		this.setSize(800, 600);
		this.setResizable(false);
		this.setTitle("TanKe");
		this.setVisible(true);
		this.addKeyListener(new MyKeyListener());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//
				System.exit(0);// 退出程序
			}
		});
	}

	/*
	 * 窗口有改变是自动调用
	 */
	@Override
	public void paint(Graphics g) {
		myTanke.paint(g);

	}

	class MyKeyListener extends KeyAdapter {
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				// x -= 10;
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				// x += 10;
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				// y += 10;
				bD = true;
				break;
			case KeyEvent.VK_UP:
				// y -= 10;
				bU = true;
				break;
			default:
				break;
			}

			// x += 200;
			// repaint();
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				// x -= 10;
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				// x += 10;
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				// y += 10;
				bD = false;
				break;
			case KeyEvent.VK_UP:
				// y -= 10;
				bU = false;
				break;
			default:
				break;
			}
			setMainTankDir();

		}

		private void setMainTankDir() {
			if (bL) {
				myTanke.setDir(Dir.LEFT);
			}
			if (bD) {
				myTanke.setDir(Dir.DOWN);
			}
			if (bU) {
				myTanke.setDir(Dir.UP);
			}
			if (bR) {
				myTanke.setDir(Dir.RIGHT);
			}

		}
	}
}
