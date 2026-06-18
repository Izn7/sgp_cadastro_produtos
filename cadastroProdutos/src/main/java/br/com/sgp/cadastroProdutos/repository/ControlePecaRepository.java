package br.com.sgp.cadastroProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sgp.cadastroProdutos.entity.ControleEstoquePecasEntity;


@Repository
public interface ControlePecaRepository extends JpaRepository<ControleEstoquePecasEntity, Integer> {

}
