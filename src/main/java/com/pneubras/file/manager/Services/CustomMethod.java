package com.pneubras.file.manager.Services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomMethod {

	
	/*OBTENÇÃO DA DATA E HORA ATUAL*/
	public String atualDateLog() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime data = LocalDateTime.now();
		LocalDateTime horaMenos3 = data.minusHours(3);/*reduz 3h da hora atual do container*/
		String atualDate = horaMenos3.format(format);
		return atualDate;
	}
	
	
	/*LISTAR TODOS OS NOMES DOS AEQUIVOS NO DIRETÓRIO*/
	public List<String> listarArquivosNoDiretorio(File file){
		List<String> nomesArquivos = new ArrayList<>();
		File[] files = file.listFiles();
		for(File fl: files) {
			nomesArquivos.add(fl.getName());
		}
		return nomesArquivos;
	}
	
	
	/*CONTAR OS ARQUIVOS NO DIRETORIO*/
	public int contarArquivosNoDiretorio(File file) {
		int contador = 0;
		File[] files = file.listFiles();
		for(File fl: files) {
			contador++;
		}
		return contador;
	}
	
	
	/* METODO PARA COPIAR ARQUIVOS */
	public void copiarArquivos(File origem, File destino, List<String> arquivosNaOrigem) {

		try {
			for (String nomeArquivo : arquivosNaOrigem) {

				/*
				 * File orig = new File(origem.toString() + nomeArquivo); File dest = new
				 * File(destino.toString() + nomeArquivo); FileUtils.moveFile(orig, dest);
				 */

				Path origemPath = Paths.get(origem.toString() + "/" + nomeArquivo);
				Path destinoPath = Paths.get(destino.toString() + "/" + nomeArquivo);
				Files.copy(origemPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (Exception e) {
			System.out.println("[ERROR] Metodo <copiarArquivos> Stacktrace --> " + e.getStackTrace() + " Message-- > " + e.getMessage());
		}

	}
	
	
	/* METODO PRA MOVER ARQUIVOS */
	public void moverArquivos(File origem, File destino, List<String> arquivosNaOrigem) {

		try {
			for (String nomeArquivo : arquivosNaOrigem) {

				Path origemPath = Paths.get(origem.toString() + "/" + nomeArquivo);
				Path destinoPath = Paths.get(destino.toString() + "/" + nomeArquivo + ".old");
				Files.move(origemPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			System.out.println("[ERROR-EXCEPTION] Metodo <moverArquivos> Stacktrace --> " + e.getStackTrace() + " Message-- > " + e.getMessage());
		}

	}
	
	
	/*METODO PARA VERIFICAR SE TODOS OS ARQUIVOS DA ORIGEM FORAM COPIADOS PARA O DESTINO*/
	public boolean verificadorDeArquivosCopiados(List<String> arquivosNoDestino, List<String> arquivosNaOrigem) {
		return arquivosNoDestino.containsAll(arquivosNaOrigem);
	}
	
	
	/* METODO PARA GRAVACAO DO ARQUIVO LOG */
	public void gravacaoLogTxt(List<String> listaDeArquivosLiberados, File caminhoLog, File caminhoOrigem, File caminhoDestino) {

		File file = new File(caminhoLog + "/log.txt");

		try {

			if (!file.exists()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				String linha01 = "/*********************************************************************************************";
				String linha02 = "*ARQUIVO DE LOG";
				String linha03 = "*MICROSERVICO: GERENCIADOR DE ARQUIVOS";
				String linha04 = "*GITHUB: https://github.com/ti-pneubras/Genrenciador-de-aquivos-de-bancos.git";
				String linha05 = "**********************************************************************************************/";
				writer.write(linha01);
				writer.newLine();
				writer.write(linha02);
				writer.newLine();
				writer.write(linha03);
				writer.newLine();
				writer.write(linha04);
				writer.newLine();
				writer.write(linha05);
				writer.newLine();
				writer.close();
			}

			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			/*** CONTEUDOS DO LOG ***/
			String linha01 = "[INFO]********************************************************************* --> " + atualDateLog();
			String linha02 = "Tipo de operação: Nexxera --> Sankhya;";
			String linha03 = "Caminho de origem: " + caminhoOrigem;
			String linha04 = "Caminho de destino: " + caminhoDestino;
			String linha05 = "Arquivos manipulados: ";

			List<String> conteudo = listaDeArquivosLiberados;

			/*** CONSOLE PARA AS LINHAS PREENCHIDAS ***/
			/*
			 * String linha; while ((linha = reader.readLine()) != null) {
			 * System.out.println("Linha existente: " + linha); }
			 */

			/*** GRAVACAO EM NOVAS LINHAS ***/
			writer.newLine();
			writer.write(linha01);
			writer.newLine();
			writer.write(linha02);
			writer.newLine();
			writer.write(linha03);
			writer.newLine();
			writer.write(linha04);
			writer.newLine();
			writer.write(linha05);
			for (int i = 0; i < conteudo.size(); i++) {
				writer.newLine();
				writer.write("Arquivo " + i + " --> " + conteudo.get(i));
			}

			writer.close();
			reader.close();

		} catch (Exception e) {
			System.out.println("Erro ao criar os leitores de arquivo");
		}

	}
}


