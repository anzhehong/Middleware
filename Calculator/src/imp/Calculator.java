package imp;

import java.rmi.RemoteException;

import bean.MyVector;
import stub.CalculatorInterface;

public class Calculator implements CalculatorInterface {
	
	public Calculator() {
		super();
	}

	@Override
	public int add(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public int subtract(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x - y;
	}


	public MyVector add(MyVector vx, MyVector vy) throws RemoteException {
		// TODO Auto-generated method stub
		MyVector myVector = new MyVector();
		myVector.setX(vx.getX() + vy.getX());
		myVector.setY(vx.getY() + vy.getY());
		
		return myVector;
	}

	

}
