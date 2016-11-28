package catalogo;

import java.util.Scanner;

/**
 *
 * @author mayara.barbosa
 */
public class Catalogo implements Runnable{
    
    
    
        @Override
        @SuppressWarnings("empty-statement")
	public void run() {
		Scanner sc = new Scanner(System.in);
		String command;
		while(true){
			command = sc.next();
			if(command.equals("!logfiles")){
				System.out.println("User --- File");
				for(Arquivo file : CatalogoServer.getFiles()){
					System.out.println(file.getNodeId + " | " + file.getnomeArquivo());
				}
			}
		}
        }
}
	


