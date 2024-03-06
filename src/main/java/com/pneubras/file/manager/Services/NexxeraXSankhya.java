package com.pneubras.file.manager.Services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NexxeraXSankhya {

	
	@Autowired
	private Directory directory;
	@Autowired
	private CustomMethod customMethod;
	
	/*NxS*/
	public void startNexxeraXSankhya() {
		
		
		File origemFile = new File(directory.getCaminhoOrigemNS());
		File destinoFile = new File(directory.getCaminhoDestinoNS());
		File logFile = new File(directory.getCaminhoLogNS());
		
		Path origemPath = Paths.get(origemFile.toString());
		Path destinoPath = Paths.get(destinoFile.toString());
		Path logPath = Paths.get(logFile.toString());
		
		List<String> arquivosNaOrigem = customMethod.listarArquivosNoDiretorio(origemFile);
		List<String> arquivosNoDestino = customMethod.listarArquivosNoDiretorio(destinoFile);
		
		int qtdArquivosOrigem = customMethod.contarArquivosNoDiretorio(origemFile);
		
				
		System.out.println("[INFO] Iniciando a copia dos arquivos   ************************************************ --> " + customMethod.atualDateLog());
		customMethod.copiarArquivos(origemFile, destinoFile, arquivosNaOrigem);
		
		System.out.println("[INFO] Movendo os arquivos   ************************************************ --> " + customMethod.atualDateLog());
		customMethod.moverArquivos(origemFile, logFile, arquivosNaOrigem);
		
				
	}
	
}
