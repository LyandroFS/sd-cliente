import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entidade.Carteira;
import rmiserver.interfaces.ServerInterface;

public class VerificarDadosServidores {
	
	
	public static void main(String[] args) {
		try {
       	 	Registry registry =  LocateRegistry.getRegistry(1099);
            for(String servidor : registry.list()) {
            	ServerInterface serverInterface = (ServerInterface) registry.lookup(servidor);
            	System.out.println("----------------------------------------------------------------");
            	System.out.println("Nome: "+serverInterface.getNome());
            	System.out.println("Operações Realizadas: "+serverInterface.getOperacoes().size());
            	System.out.println("        =============>");
            	for (Carteira carteira : serverInterface.selectCarteiras()) {
            		System.out.println(carteira.getNome()+" (Conta: "+carteira.getNumeroCarteira()+")");
            		System.out.println(carteira.getSaldo());
				}
            	
            }
		} catch (Exception e){
           e.printStackTrace();
       } 
	}
}
