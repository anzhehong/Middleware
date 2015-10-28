package stub;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.MyVector;

public interface CalculatorInterface extends Remote{
	public int add(int x, int y) throws RemoteException;
	public int subtract(int x, int y) throws RemoteException;
	
	public MyVector add(MyVector vx, MyVector vy) throws RemoteException;
}
