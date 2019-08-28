
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entidade.Carteira;
import rmiserver.interfaces.ServerInterface;

public class Client extends UnicastRemoteObject implements ServerInterface , Runnable {
    private static final long serialVersionUID = 1L;
    private static ServerInterface server;

    Registry registry;
    
    protected Client() throws RemoteException {
    }
 
    public void broadcastMessage(String message) throws RemoteException {}
    
    public void run() {
    	
    	Scanner scanner = new Scanner(System.in);
        String message = null;
        boolean chkExit = true;        
        
        while(true) {
        	System.out.println("Informe o comando SQL \n");
            message = scanner.nextLine();
            if(message.equals("LOGOUT")) {
                chkExit = false;
            }else {
                try {
                	Registry registry =  LocateRegistry.getRegistry(1099);
                	for(String server : registry.list()) {
                		ServerInterface chatinterface = (ServerInterface) registry.lookup(server);
                		if(chatinterface.isLider()) {
                			System.out.println("Enviando para: "+ chatinterface.getNome());
                			try {
								chatinterface.broadcastMessage(message);
							} catch (RemoteException e) {
								e.printStackTrace();
							}
                		}
                	}
                }catch (Exception e) {
					e.printStackTrace();
				}
            }  
        } 
    }
    
    public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException {
    	new Thread(new Client()).start();
    }
   
	@Override
	public void setLider(boolean isLider) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isLider() throws RemoteException {
		return false;
	}
	
	@Override
    public void setId(int id) throws RemoteException {
 	}

    @Override
    public int getId() throws RemoteException {
 	   return 0;
    }
    
    @Override
	public void setNome(String nome) throws RemoteException {
	}

	@Override
	public String getNome() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	} 
	
	@Override
	public int getIdUltimaOperaco() throws RemoteException {
		return 0;
	}
	
	@Override
	public Map<Integer, String> getOperacoes() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean depositoCarteira(int numeroCarteira, double valor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saqueCarteira(int numeroCarteira, double valor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferenciaCarteira(int numeroCarteiraOrigem, int numeroCarteiraDestino, double valor)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double getSaldoCarteira(int numeroCarteira) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carteira selectCarteira(int numeroCarteira) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean criarCarteria(Carteira carteira) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Carteira> selectCarteiras() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	} 
}