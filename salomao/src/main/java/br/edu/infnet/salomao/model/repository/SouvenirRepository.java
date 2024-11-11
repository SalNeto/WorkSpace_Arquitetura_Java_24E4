package br.edu.infnet.salomao.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.salomao.model.domain.Souvenir;

@Repository
public interface SouvenirRepository extends CrudRepository<Souvenir, Integer> {
}