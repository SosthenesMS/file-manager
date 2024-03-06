package com.pneubras.file.manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pneubras.file.manager.Services.NexxeraXSankhya;


@RestController
public class NexxeraXSankhyaController {

	@Autowired
	private NexxeraXSankhya nexxeraXSankhya;
	
	public void startNexxeraXSankhya() {
		nexxeraXSankhya.startNexxeraXSankhya();
	}
}
