package br.com.sgp.cadastroProdutos.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produtos")
public class ProdutosEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String sku;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String categoria; 
	
	private String marca;
	
	private long idFornecedor;
	
	@Column(nullable = false)
	private float precoCusto;
	
	@Column(nullable = false)
	private float precoVenda;
	
	@Column(nullable = false)
	private float peso;
	
	@Column(nullable = false)
	private int estoqueMin;
	
	@Column(nullable = false)
	private int estoqueMax;
	
	@Column(nullable = false)
	private boolean ativo;

	

	

	public long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

	public int getEstoqueMax() {
		return estoqueMax;
	}

	public void setEstoqueMax(int estoqueMax) {
		this.estoqueMax = estoqueMax;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
