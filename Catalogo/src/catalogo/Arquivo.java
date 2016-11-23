package catalogo;
/**
 *
 * @author mayara.barbosa
 */
public class Arquivo {
    
    private String nomeArquivo;
    private int tamanhoArquivo;
    
    public Arquivo(){
        
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public int getTamanhoArquivo() {
        return tamanhoArquivo;
        //file.length();
    }

    public void setTamanhoArquivo(int tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    
    
    
}
