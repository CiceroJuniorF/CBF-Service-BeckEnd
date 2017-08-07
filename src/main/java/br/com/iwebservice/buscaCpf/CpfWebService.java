package br.com.iwebservice.buscaCpf;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
*
* @author Wesley Araujo
*/

public class CpfWebService {
    
    private int Resultado = 0;
    private String ResultadoTXT = "";
    private String Titular = "";
    private String Cpf = "";
    private String DataNascimento = "";
    private String Sexo = "";
    private String Situacao = "";
    private String NomeMae = "";
    
    private String Logradouro = "";
    private String Numero = "";
    private String Complemento = "";
    private String Bairro = "";
    private String Cidade = "";
    private String UF = "";
    private String Cep = "";
    
    /** Creates a new instance of CpfWebService */
    
	@SuppressWarnings("rawtypes")
	public CpfWebService(String cpf, String dataNascimento, String chave) {
        try {
            URL url = new URL("http://ws.iwebservice.com.br/CPF/?cpf=" + cpf + "&dataNascimento=" + dataNascimento + "&formato=xml&chave=" + chave);
         
            Document document = getDocumento(url);

            Element root = document.getRootElement();

            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                
                if (element.getQualifiedName().equals("msg")){
                	for ( Iterator u= element.elementIterator(); u.hasNext(); ) {
                	Element msg = (Element) u.next();	
                
		                if (msg.getQualifiedName().equals("Resultado"))
		                    setResultado(Integer.parseInt(msg.getText()));                
		                
		                if (msg.getQualifiedName().equals("ResultadoTXT"))
		                    setResultadoTXT(msg.getText());  
                	}    
                }
            }            

            
            for ( Iterator j = root.elementIterator(); j.hasNext(); ) {
                Element element = (Element) j.next();
         
                if (element.getQualifiedName().equals("DadosTitular")){
                              	
                	for ( Iterator u= element.elementIterator(); u.hasNext(); ) {
                        Element dadosTitular = (Element) u.next();

                if (dadosTitular.getQualifiedName().equals("Cpf"))
                    setCpf(dadosTitular.getText());
                
                if (dadosTitular.getQualifiedName().equals("DataNascimento"))
                    setDataNascimento(dadosTitular.getText());   
                
                if (dadosTitular.getQualifiedName().equals("Titular"))
                    setTitular(dadosTitular.getText());           
                
                if (dadosTitular.getQualifiedName().equals("Sexo"))
                    setSexo(dadosTitular.getText());           
                
                if (dadosTitular.getQualifiedName().equals("Situacao"))
                    setSituacao(dadosTitular.getText());         
                
                if (dadosTitular.getQualifiedName().equals("NomeMae"))
                    setNomeMae(dadosTitular.getText()); 
                }
            }
 
            if (element.getQualifiedName().equals("EnderecoTitular")){
                
            	
            	for ( Iterator u= element.elementIterator(); u.hasNext(); ) {
                    Element enderecoTitular = (Element) u.next();            
            
                if (enderecoTitular.getQualifiedName().equals("Logradouro"))
                    setLogradouro(enderecoTitular.getText()); 
                
                if (enderecoTitular.getQualifiedName().equals("Numero"))
                    setNumero(enderecoTitular.getText()); 
                
                if (enderecoTitular.getQualifiedName().equals("Complemento"))
                    setComplemento(enderecoTitular.getText()); 
                
                if (enderecoTitular.getQualifiedName().equals("Bairro"))
                    setBairro(enderecoTitular.getText()); 
                
                if (enderecoTitular.getQualifiedName().equals("Cidade"))
                    setCidade(enderecoTitular.getText()); 
                
                if (enderecoTitular.getQualifiedName().equals("UF"))
                    setUF(enderecoTitular.getText()); 
                
                if (enderecoTitular.getQualifiedName().equals("Cep"))
                    setCep(enderecoTitular.getText()); 
            	}
            }
            }
        }
           
        catch (Exception ex) {
            ex.printStackTrace();
        }        
    }

    public Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    } 
    
    public int getResultado() {
        return Resultado;
    }

    public void setResultado(int Resultado) {
        this.Resultado = Resultado;
    }

    public String getResultadoTXT() {
        return ResultadoTXT;
    }

    public void setResultadoTXT(String ResultadoTXT) {
        this.ResultadoTXT = ResultadoTXT;
    }
    
    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
    
    
    public String getTitular() {
        return Titular;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }
    
    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }
        
    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String NomeMae) {
        this.NomeMae = NomeMae;
    }    
    
    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }    
    
    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }    
    
    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }    
    
    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }    
    
    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }    
    
    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }    
    
    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }    
    
}