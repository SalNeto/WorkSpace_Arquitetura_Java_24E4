package br.edu.infnet.salomao.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.salomao.model.domain.Mercadoria;

@Repository
public interface MercadoriaRepository extends CrudRepository<Mercadoria, Integer> {

	List<Mercadoria> findByPrecoBetween(float precoInicial, float precoFinal);
}
