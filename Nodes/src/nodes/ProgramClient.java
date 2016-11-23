package nodes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author mayara.barbosa
 */
public class ProgramClient {

    
    public static void main(String[] args) throws IOException {
        char letra = 'a';
        //test conexao com o server
        Socket nodeSocket;
        nodeSocket = new Socket("10.96.26.40", 9999);//endereço ip e porta
        
        OutputStream os = nodeSocket.getOutputStream();
        DataOutputStream dos;
        dos = new DataOutputStream(os);
        dos.writeChar(letra);
        InputStream is = nodeSocket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        letra = dis.readChar();
        System.out.println("Letra enviada pelo server");
        System.out.println(letra);
    }
    
}
