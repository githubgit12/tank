package TK;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TanKeFrame extends Frame {

	Tanke myTanke = new Tanke(200, 200, Dir.DOWN, this);
	List<Bullet> bullets = new ArrayList<Bullet>();
	Bullet b = new Bullet(300, 300, Dir.DOWN, this);
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

	public TanKeFrame() {

		this.setSize(GAME_WIDTH, GAME_HEIGHT);
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

	/**
	 * 双缓冲 消除闪烁
	 */
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScreen = offScreenImage.getGraphics();
		Color c = goffScreen.getColor();
		goffScreen.setColor(Color.BLACK);
		goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreen.setColor(c);
		paint(goffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	/*
	 * 窗口有改变是自动调用
	 */
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量" + bullets.size(), 10, 60);
		g.setColor(c);

		myTanke.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
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
			case KeyEvent.VK_CONTROL:
				myTanke.fire();
			default:
				break;
			}
			setMainTankDir();

		}

		private void setMainTankDir() {
			if (!bL && !bD && !bR && !bU) {
				myTanke.setMoving(false);
			} else {
				myTanke.setMoving(true);
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
}
