package br.com.cbf.service;

public interface UsuarioService {
	 String encriptarSenha(String senha);
	 
	 String solicitarAlteracaoDeSenha(String senha);
	 
	 String alterarSenha(String senha);
}
