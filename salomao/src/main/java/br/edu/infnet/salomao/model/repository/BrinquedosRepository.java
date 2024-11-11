package br.edu.infnet.salomao.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.salomao.model.domain.Brinquedos;

@Repository
public interface BrinquedosRepository extends CrudRepository<Brinquedos, Integer> {
}