package br.edu.infnet.salomao.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	private int codigo;
	private float preco;
	private boolean estoque;
		
	@ManyToOne
	@JoinColumn(name = "idVendedor")
	@JsonBackReference
	private Vendedor vendedor;

	@Override
	public String toString() {

		return String.format("%s - %d - %.2f - %s", 
				descricao,
				codigo,
				preco,
				estoque ? "estoque: sim" : "estoque: não"
			);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEstoque() {
		return estoque;
	}

	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}