import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PararServico {
	
	
	public static void main(String[] args) {
		stopServer();
	}
	
	 public static void stopServer()
	    {
	    System.out.println("Stopping server");
	        try {

	        	 Registry registry =  LocateRegistry.getRegistry(1099);
	             registry.unbind("BancoService2");

	            //UnicastRemoteObject.unexportObject(registry, true);

	        } catch (Exception e){
	            e.printStackTrace();
	        } 
	    }
}
