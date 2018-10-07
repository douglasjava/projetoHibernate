package br.com.estudos.jpa.projetojpa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.jpa.projetojpa.model.Proprietario;
import br.com.estudos.jpa.projetojpa.repository.ProprietarioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/proprietario")
public class ProprietarioResource {

	@Autowired
	private ProprietarioRepository proprietario;

	@GetMapping
	private List<Proprietario> listar() {
		return proprietario.findAll();
	}

}
