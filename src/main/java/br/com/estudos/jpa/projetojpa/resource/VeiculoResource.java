package br.com.estudos.jpa.projetojpa.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.jpa.projetojpa.model.Veiculo;
import br.com.estudos.jpa.projetojpa.repository.VeiculoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

	@Autowired
	private VeiculoRepository veiculos;

	@GetMapping
	private List<Veiculo> listar() {
		return veiculos.findAll();
	}

	@PostMapping
	private Veiculo adcionar(@RequestBody @Valid Veiculo veiculo) {
		return veiculos.save(veiculo);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Veiculo> buscar(@PathVariable Long id) {
		Veiculo veiculo = null;
		Optional<Veiculo> optVeiculo = veiculos.findById(id);

		if (optVeiculo.isPresent()) {
			veiculo = optVeiculo.get();
		}

		if (veiculo == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(veiculo);

	}

	@GetMapping("/{fabricante}/{id}")
	public List<Veiculo> buscarPorFabricante(@PathVariable String fabricante) {
		return veiculos.findByFabricante(fabricante);
	}

}