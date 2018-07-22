package br.com.estudos.jpa.projetojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.jpa.projetojpa.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByFabricante(String fabricante);
}
