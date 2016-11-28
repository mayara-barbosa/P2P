/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogo;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayara.barbosa
 */
public class NodeCliente implements Runnable{
    
    private DataOutputStream out;
	private DataInputStream in;
	private ArrayList<UserFile> availableFiles = new ArrayList<>();
	
	public ClientListener(Socket socket) throws IOException{
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Novo usuario conectado");
			out.writeUTF("Conectado com sucesso.");
			String input = in.readUTF();
			String[] files = input.split("%&");;
			
			for(String file : files){
				System.out.println(file + " adicionado ao catalogo.");
				availableFiles.add(new UserFile(file, CatalogServer.clients.indexOf(this)));
			}
			
			String inputString;
			String outputString;
			while(true){
				outputString = "";
				inputString = in.readUTF();
				if(inputString.contains("%&0")){
					for(UserFile file : CatalogServer.getFiles()){
						outputString += file.getListenerIndex() + " | " + file.getFilename() + "%&";
					}
				} else if(inputString.contains("%&1")){ //solicitação de arquivo
					inputString = inputString.substring(2, inputString.indexOf("%&n"));
					for(ClientListener client : CatalogServer.getClientByFilename(inputString)){
						
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Arquivo> getAvailableFiles() {
		return (ArrayList<Arquivo>) availableFiles;
	}

	public void setAvailableFiles(ArrayList<UserFile> availableFiles) {
		this.availableFiles = availableFiles;
	}
    
    
}
