package br.edu.infnet.salomao.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.salomao.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

	List<Vendedor> findByNomeContaining(String nome);
}