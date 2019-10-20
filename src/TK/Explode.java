package TK;

import java.awt.*;

public class Explode {

	public static int WIDTH = ResoureMgr.explodes[0].getWidth();
	public static int HEIGHT = ResoureMgr.explodes[0].getHeight();

	private boolean living = true;

	private int x, y;

    TanKeFrame tf = null;

	private int step = 0;

	public Explode(int x, int y,TanKeFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		g.drawImage(ResoureMgr.explodes[step++],x,y,null);
		if(step >= ResoureMgr.explodes.length){
			step = 0;
		}

	}

}
