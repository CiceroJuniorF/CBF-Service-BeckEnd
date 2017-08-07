package br.com.iwebservice.buscaCep;

import java.net.URL;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author Wesley Aarujo
 */

public class CepWebService {
    
    private int Resultado = 0;
    private String ResultadoTXT = "";
    
    private String Cep = "";
    
    private String Descricao = "";
    
    private String Logradouro = "";
    private String Numero = "";
    private String Complemento = "";
    private String Bairro = "";
    private String Cidade = "";
    private String UF = "";
    
    private String Capital = "";
    private String DDD = "";
    private String IbgeUF = "";
    private String CodIbgeMunicipio = "";
    private String Populacao = "";
    private String PopulacaoHomens = "";
    private String PopulacaoMulheres = "";
    
    private String Latitude = "";
    private String Longitude = "";
    
    /** Creates a new instance of CepWebService */
    
	@SuppressWarnings("rawtypes")
	public CepWebService(String cep, String chave) {
        try {
            URL url = new URL("http://ws.iwebservice.com.br/CEP/?cep=" + cep + "&chave=" + chave + "&formato=xml");
         
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
         
                if (element.getQualifiedName().equals("DadosCorreios")){
                
                	
                	for ( Iterator u= element.elementIterator(); u.hasNext(); ) {
                        Element dadosCorreios = (Element) u.next();

                        if (dadosCorreios.getQualifiedName().equals("Descricao"))
                            setDescricao(dadosCorreios.getText());     
                        
                        if (dadosCorreios.getQualifiedName().equals("Cep"))
                            setCep(dadosCorreios.getText()); 
                        
                        if (dadosCorreios.getQualifiedName().equals("Logradouro"))
                            setLogradouro(dadosCorreios.getText());           
                        
                        if (dadosCorreios.getQualifiedName().equals("Numero"))
                            setNumero(dadosCorreios.getText()); 
                       
                        if (dadosCorreios.getQualifiedName().equals("Bairro"))
                            setBairro(dadosCorreios.getText());                
                        
                        if (dadosCorreios.getQualifiedName().equals("Cidade"))
                            setCidade(dadosCorreios.getText());                
                        
                        if (dadosCorreios.getQualifiedName().equals("UF"))
                            setUF(dadosCorreios.getText());  
       
                	}
                }
               
                if (element.getQualifiedName().equals("DadosIbge")){
                
                	
                	for ( Iterator u= element.elementIterator(); u.hasNext(); ) {
                        Element dadosIbge = (Element) u.next();
                        
                      if (dadosIbge.getQualifiedName().equals("Capital"))
                    	  setCapital(dadosIbge.getText());  
                      
                      if (dadosIbge.getQualifiedName().equals("DDD"))
                    	  setDDD(dadosIbge.getText());  
                      
                      if (dadosIbge.getQualifiedName().equals("IbgeUF"))
                          setIbgeUF(dadosIbge.getText());  
                      
                      if (dadosIbge.getQualifiedName().equals("CodIbgeMunicipio"))
                          setCodIbgeMunicipio(dadosIbge.getText());  
                      
                      if (dadosIbge.getQualifiedName().equals("Populacao"))
                          setPopulacao(dadosIbge.getText());  
                      
                      if (dadosIbge.getQualifiedName().equals("PopulacaoHomens"))
                          setPopulacaoHomens(dadosIbge.getText());  
                      
                      if (dadosIbge.getQualifiedName().equals("PopulacaoMulheres"))
                          setPopulacaoMulheres(dadosIbge.getText());  
                        
                	}
                }                
                
              
                
                if (element.getQualifiedName().equals("DadosGoogle")){
                
                	
                	for ( Iterator s= element.elementIterator(); s.hasNext(); ) {
                        Element dadosGoogle = (Element) s.next();
                      
                        
                      if (dadosGoogle.getQualifiedName().equals("Latitude"))
                            setLatitude(dadosGoogle.getText());  
                      
                      if (dadosGoogle.getQualifiedName().equals("Longitude"))
                          setLongitude(dadosGoogle.getText());  
                      
  
                        
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
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
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
    
    public String getCapital() {
        return Capital;
    }
    
    public void setCapital(String Capital) {
        this.Capital = Capital;
    }
    
    public String getDDD() {
        return DDD;
    }
    
    public void setDDD(String DDD) {
        this.DDD = DDD;
    }
    
    public String getIbgeUF() {
        return IbgeUF;
    }
    
    public void setIbgeUF(String IbgeUF) {
        this.IbgeUF = IbgeUF;
    }
    
    public String getCodIbgeMunicipio() {
        return CodIbgeMunicipio;
    }
    
    public void setCodIbgeMunicipio(String CodIbgeMunicipio) {
        this.CodIbgeMunicipio = CodIbgeMunicipio;
    }
    
    public String getPopulacao() {
        return Populacao;
    }
    
    public void setPopulacao(String Populacao) {
        this.Populacao = Populacao;
    }
    
    public String getPopulacaoHomens() {
        return PopulacaoHomens;
    }
    
    public void setPopulacaoHomens(String PopulacaoHomens) {
        this.PopulacaoHomens = PopulacaoHomens;
    }
    
    public String getPopulacaoMulheres() {
        return PopulacaoMulheres;
    }
    
    public void setPopulacaoMulheres(String PopulacaoMulheres) {
        this.PopulacaoMulheres = PopulacaoMulheres;
    }
    
    public String getLatitude() {
        return Latitude;
    }
    
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }
    
    public String getLongitude() {
        return Longitude;
    }
    
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }
    
}