package com.pneubras.file.manager;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pneubras.file.manager.Controller.NexxeraXSankhyaController;
import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class FileManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileManagerApplication.class, args);
	}
	
	@Autowired
	NexxeraXSankhyaController nexxeraXSankhyaController;
	
	@PostConstruct
	public void init() {
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				System.out.println("********************** INICIANDO GERENCIADOR DE ARQUIVOS - NEXXERA X SANKHYA ************************");
				/*NxS*/
				nexxeraXSankhyaController.startNexxeraXSankhya();
				
				System.out.println("********************** FINALIZANDO GERENCIADOR DE ARQUIVOS - NEXXERA X SANKHYA **********************");
								
			}
			
		}, 2, 1 * 60 * 1000); // 02 min
		
		
	}

}
