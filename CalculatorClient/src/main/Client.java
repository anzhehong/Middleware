package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import bean.MyVector;
import stub.CalculatorInterface;
import stub.TemperatureInterface;
public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub

		//寻找远端服务
		//Calculator
		Registry reg = LocateRegistry.getRegistry("localhost",2015);
		CalculatorInterface ci = (CalculatorInterface) (reg.lookup("cal"));
		
//		MyVector vx = new MyVector(), vy =new MyVector();
//		vx.setX(50); vx.setY(100);
//		vy.setX(-100); vy.setY(-200);
//		MyVector vz = ci.add(vx, vy);
		
		
		int result = ci.add(5, 8);
		System.out.println(result);
		System.out.println("aaa");
		
		//Temperature convert
		
		Registry regTmp = LocateRegistry.getRegistry("localhost",2016);
		TemperatureInterface temp = (TemperatureInterface) (regTmp.lookup("temp"));
		float resultTemp = temp.convertToFahrenheit(26);
		System.out.println("temperature:");
		System.out.println(resultTemp);
	}

}
