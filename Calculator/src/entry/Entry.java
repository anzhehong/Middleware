package entry;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import imp.Calculator;
import imp.Temperature;
import stub.CalculatorInterface;
import stub.TemperatureInterface;

public class Entry {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		//创建服务器对象实例
		Calculator c = new Calculator();
		
		CalculatorInterface ci = (CalculatorInterface)(UnicastRemoteObject.exportObject(c, 0));
		Registry reg = LocateRegistry.createRegistry(2015);
		reg.rebind("cal", ci);
		
		System.out.println("calculator in service...press ENTER to exit");
//		Scanner s = new Scanner(System.in);
//		s.next();
//		UnicastRemoteObject.unexportObject(c,true);
		
		
		Temperature tmp = new Temperature();
		TemperatureInterface temperatureInterface = (TemperatureInterface) UnicastRemoteObject.exportObject(tmp,0);
		Registry regTmp = LocateRegistry.createRegistry(2016);
		regTmp.rebind("temp", temperatureInterface);
		System.out.println("temperature in service");
	}

}
