package com.pneubras.file.manager.Services;

import org.springframework.stereotype.Service;

@Service
public class Directory {

	
	/*NxS*/
	//String caminhoOrigemNS = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIAR";
	String caminhoOrigemNS = "/ftp_nexxera/REMESSA/ENVIARs";
	//String caminhoDestinoNS = "/home/sosthenes-mendonca/Área de Trabalho/SANKHYA";
	String caminhoDestinoNS = "/svr_prod/REMESSA/ENVIARs";
	//String caminhoLogNS = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIADOS";
	String caminhoLogNS = "/ftp_nexxera/REMESSA/ENVIADOSs";
	
	
	/*SxN*/
	//String caminhoOrigemSN = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIAR";
	String caminhoOrigemSN = "/svr_prod/RETORNO/PROCESSARs";
	//String caminhoDestinoSN = "/home/sosthenes-mendonca/Área de Trabalho/SANKHYA";
	String caminhoDestinoSN = "/ftp_nexxera/RETORNO/PROCESSARs";
	//String caminhoLogSN = "/home/sosthenes-mendonca/Área de Trabalho/NEXXERA/REMESSA/ENVIADOS";
	String caminhoLogSN = "/ftp_nexxera/RETORNO/PROCESSADOSs";
	
	
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
