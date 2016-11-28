package catalogo;
/**
 *
 * @author mayara.barbosa
 */
public class Arquivo {
    
    private String nomeArquivo;
    private int nodeId;
    private byte[] arquivo;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
  
    
    public Arquivo(String nomeArquivo, int nodeId){
        this.nomeArquivo = nomeArquivo;
        this.nodeId = nodeId;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public byte[] getTamanhoArquivo() {
        return arquivo;
        //file.length();
    }

    public void setTamanhoArquivo(byte [] tamanhoArquivo) {
        this.arquivo = arquivo;
    }
}
