package br.com.sgp.cadastroProdutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sgp.cadastroProdutos.entity.ProdutosEntity;



@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long>{

	List<ProdutosEntity> findBySku (String sku);
	List<ProdutosEntity> findByDescricao (String descricao);
	List<ProdutosEntity> findByCategoria (String categoria);
	List<ProdutosEntity> findByAtivo (boolean ativo);
	
	List<ProdutosEntity> findBySkuOrDescricaoOrCategoriaOrAtivo(String sku,String descricao,String categoria,boolean ativo);
}
