package br.com.iwebservice.buscaCep;

/**
*
* @author Wesley Aarujo
*/

public class BuscaEndereco {
    
    public static void main(String[] args) {
        new BuscaEndereco();
    }
    
    public BuscaEndereco() {
        try {
            
            // 35620-000 - Exemplo de CEP Unico 
            // 22250-970 - Exemplo de CEP Agencia dos Correios 
            // 22250-901 - Exemplo de CEP Comercial 
        	
            String cep = "22250-040";//Informa aqui o CEP para consulta - COM ou SEM hifem                                  
            String chave = "XXXXX-XXXXX-XXXXX-XXXXX";//Informe aqui a sua CHAVE de Acesso Gratuita criada em nosso site:  www.iWebService.com.br

            CepWebService cepWebService = new CepWebService(cep, chave);
                        
            if (cepWebService.getResultado()==3) {
                System.out.println("Resultado     : " + cepWebService.getResultado());
                System.out.println("ResultadoTXT  : " + cepWebService.getResultadoTXT());
            } else if (cepWebService.getResultado()==0 || cepWebService.getResultado()==2 || cepWebService.getResultado()==3) {
                System.out.println("Resultado     : " + cepWebService.getResultado());
                System.out.println("ResultadoTXT  : " + cepWebService.getResultadoTXT());
                System.out.println("CEP 	      : " + cepWebService.getCep());  
            } else if (cepWebService.getResultado()==1) {
                System.out.println("Resultado         : " + cepWebService.getResultado());
                System.out.println("ResultadoTXT      : " + cepWebService.getResultadoTXT());
                System.out.println("Descri��o         : " + cepWebService.getDescricao());
                System.out.println("CEP 	          : " + cepWebService.getCep());
                if(cepWebService.getNumero().equals(" ")){
                	System.out.println("Endere�o          : " + cepWebService.getLogradouro());
                } else {
                    System.out.println("Endere�o          : " + cepWebService.getLogradouro() + ", " + cepWebService.getNumero());
                }
                //System.out.println(cepWebService.getNumero());
                System.out.println("Bairro            : " + cepWebService.getBairro());
                System.out.println("Cidade            : " + cepWebService.getCidade());
                System.out.println("UF                : " + cepWebService.getUF()); 
                System.out.println("Capital           : " + cepWebService.getCapital());
                System.out.println("DDD               : " + cepWebService.getDDD());
                System.out.println("C�digo Ibge UF    : " + cepWebService.getIbgeUF());
                System.out.println("C�digo Municipio  : " + cepWebService.getCodIbgeMunicipio());
                System.out.println("Popula��o Total   : " + cepWebService.getPopulacao());
                System.out.println("Popula��o Homens  : " + cepWebService.getPopulacaoHomens());
                System.out.println("Popula��o Mulheres: " + cepWebService.getPopulacaoMulheres());
                System.out.println("Latitude          : " + cepWebService.getLatitude());
                System.out.println("Longitude         : " + cepWebService.getLongitude());
            }                       
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }  
    }    
}