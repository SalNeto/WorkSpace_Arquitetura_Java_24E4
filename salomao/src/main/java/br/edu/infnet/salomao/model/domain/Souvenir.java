package br.edu.infnet.salomao.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TSouvenir")
public class Souvenir extends Mercadoria {
	private boolean organico;
	private String caracteristica;

	public boolean isOrganico() {
		return organico;
	}
	public void setOrganico(boolean organico) {
		this.organico = organico;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
}