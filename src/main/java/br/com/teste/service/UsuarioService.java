package br.com.teste.service;

public interface UsuarioService {
	 String encriptarSenha(String senha);
	 
	 String solicitarAlteracaoDeSenha(String senha);
	 
	 String alterarSenha(String senha);
}
