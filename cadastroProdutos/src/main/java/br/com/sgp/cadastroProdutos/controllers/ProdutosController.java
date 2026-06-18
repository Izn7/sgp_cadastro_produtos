package br.com.sgp.cadastroProdutos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.sgp.cadastroProdutos.entity.ProdutosEntity;
import br.com.sgp.cadastroProdutos.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutosController {

		@Autowired
		public ProdutosRepository produtosRepository;
		
				//acharId
				@GetMapping("/{id}")
				@ResponseStatus(HttpStatus.OK)
				public Optional<ProdutosEntity> buscarId(@PathVariable Long id){
					return produtosRepository.findById(id);
				}
				
				//acharTodos
				@GetMapping("/acharTodos")
				@ResponseStatus(HttpStatus.OK)
				public List<ProdutosEntity> buscarTodos(){
					return produtosRepository.findAll();
				}
				
				//gravar
				@PostMapping("/gravar")
				@ResponseStatus(HttpStatus.CREATED)
				public ProdutosEntity Gravar(@RequestBody ProdutosEntity produtosEntity) {
					return produtosRepository.save(produtosEntity);
					
				}
				
				
				//atualizar
				@PutMapping("/atualizar/{id}")
				@ResponseStatus(HttpStatus.OK)
				public ProdutosEntity atualizar(@RequestBody ProdutosEntity produtosEntity, @PathVariable Long id) {
					produtosEntity.setId(id);
					return produtosRepository.save(produtosEntity);
				}
				
				//deletar
				@DeleteMapping("/deletar/{id}")
				@ResponseStatus(HttpStatus.OK)
				public String Deletar(@PathVariable Long id) {
					if(produtosRepository.existsById(id)) {
						produtosRepository.deleteById(id);
						return "Deletado";
					}
						return "Não Deletado";
					}

              @GetMapping("/filtrar/{sku}/{descricao}/{categoria}/{ativo}")
              @ResponseStatus(HttpStatus.OK)
              public List<ProdutosEntity> Filtrar(@PathVariable String sku, @PathVariable String descricao, @PathVariable String categoria, @PathVariable Boolean ativo){
            	  return produtosRepository.findBySkuOrDescricaoOrCategoriaOrAtivo(sku, descricao, categoria, ativo);
            			  
              }
              
              @GetMapping("/buscaDesc/{descricao}")
              @ResponseStatus(HttpStatus.OK)
              public List<ProdutosEntity> BuscarPorDescricao (@PathVariable String descricao){
            	  return produtosRepository.findByDescricao(descricao);
              }
	
}
