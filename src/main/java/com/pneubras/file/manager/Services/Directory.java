package com.pneubras.file.manager.Services;

import org.springframework.stereotype.Service;

@Service
public class Directory {

	
	/*NxS*/
	//String caminhoOrigemNS = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIAR";
	String caminhoOrigemNS = "/ftp_nexxera/REMESSA/ENVIAR";
	//String caminhoDestinoNS = "/home/sosthenes-mendonca/Área de Trabalho/SANKHYA";
	String caminhoDestinoNS = "/svr_prod/REMESSA/ENVIAR";
	//String caminhoLogNS = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIADOS";
	String caminhoLogNS = "/ftp_nexxera/REMESSA/ENVIADOS";
	
	
	/*SxN*/
	//String caminhoOrigemSN = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIAR";
	String caminhoOrigemSN = "/svr_prod/RETORNO/PROCESSAR";
	//String caminhoDestinoSN = "/home/sosthenes-mendonca/Área de Trabalho/SANKHYA";
	String caminhoDestinoSN = "/ftp_nexxera/RETORNO/PROCESSAR";
	//String caminhoLogSN = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIADOS";
	String caminhoLogSN = "/ftp_nexxera/RETORNO/PROCESSADOS";
	
	
	public String getCaminhoOrigemNS() {
		return caminhoOrigemNS;
	}
	public String getCaminhoDestinoNS() {
		return caminhoDestinoNS;
	}
	public String getCaminhoLogNS() {
		return caminhoLogNS;
	}
	public String getCaminhoOrigemSN() {
		return caminhoOrigemSN;
	}
	public String getCaminhoDestinoSN() {
		return caminhoDestinoSN;
	}
	public String getCaminhoLogSN() {
		return caminhoLogSN;
	}
	
	
	
	
}
