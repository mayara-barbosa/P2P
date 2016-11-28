package catalogo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author mayara.barbosa
 */
public class CatalogoServer {

         
        private static ServerSocket serverSocket;
	public static ArrayList<NodeCliente> nos = new ArrayList<>();
	
	public static void main(String args[]){
		
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Thread(new Catalogo()).start();
		
		while(true){
			try {
				NodeCliente listener = new NodeCliente(serverSocket.accept());
				nos.add(listener);
				new Thread(listener).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<NodeCliente> getClientByFilename(String arquivo){
		ArrayList<NodeCliente> todosClientes = new ArrayList<>();
		for(NodeCliente client : nos){
			for(Arquivo arq : client.getAvailableFiles()){
				if(arq.getNomeArquivo().equals(arquivo)){
					todosClientes.add(client);
				}
			}
		}
		return todosClientes;
	}
	
	public static ArrayList<Arquivo> getFiles(){
		ArrayList<Arquivo> files = new ArrayList<Arquivo>();
		for(NodeCliente client : clients){
			files.addAll(client.getAvailableFiles());
		}
		return files;
	}
        
        
    }
    

