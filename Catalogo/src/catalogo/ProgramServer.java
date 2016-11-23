package catalogo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mayara.barbosa
 */
public class ProgramServer {

    public static void main(String[] args) throws IOException {
        
        ServerSocket catalogoSocket;
        catalogoSocket = new ServerSocket(9999);
        
        // teste de conexao com os nodes
        Socket nodeSocket; 
        nodeSocket = catalogoSocket.accept();//<- funcao bloqueante
        InputStream is = nodeSocket.getInputStream();
        DataInputStream dis  = new DataInputStream(is);// decorator
        
        char letra; 
        letra = dis.readChar();
        System.out.println("letra enviada pelo cliente");
        System.out.println(letra);
        
        OutputStream os = nodeSocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeChar(Character.toUpperCase(letra));
        
        
    }
    
}
