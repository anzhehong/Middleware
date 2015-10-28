package bean;

import java.io.Serializable;

public class MyVector implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private 
	private int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
