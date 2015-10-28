package stub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureInterface extends Remote {

	public float convertToFahrenheit(float degree) throws RemoteException;
}
