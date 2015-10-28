package imp;

import java.rmi.RemoteException;

import stub.TemperatureInterface;

public class Temperature implements TemperatureInterface {

	public Temperature(){
		super();
	}

	@Override
	public float convertToFahrenheit(float degree) throws RemoteException {
		
		return degree * 1.8f + 32;
	}
	
	

}
