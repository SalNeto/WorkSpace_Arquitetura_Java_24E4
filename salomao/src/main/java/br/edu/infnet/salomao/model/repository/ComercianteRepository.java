package br.edu.infnet.salomao.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.salomao.model.domain.Comerciante;

@Repository
public interface ComercianteRepository extends CrudRepository<Comerciante, Integer> {

	List<Comerciante> findByNomeContaining(String nome, Sort by);
	
	Iterable<Comerciante> findAll(Sort by);
}