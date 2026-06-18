package br.com.sgp.cadastroProdutos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.cadastroProdutos.entity.ControlePecaEntity;
import br.com.sgp.cadastroProdutos.repository.ControlePecaRepository;


@RestController
@RequestMapping("/ControlePecas")
public class ControlePecaControllers {



		
		



							@Autowired
							private ControlePecaRepository controlePeca;
							
							
							
							@GetMapping("/BuscarTodos")
							@ResponseStatus(HttpStatus.OK)
							public List<ControlePecaEntity> buscarTodasPeças(){
								return controlePeca.findAll();
								
							}
							@GetMapping("/BuscarPorId/{id}")
							@ResponseStatus(HttpStatus.OK)
							public Optional<ControlePecaEntity> buscarPeçasPorId(@PathVariable Integer id){
								return controlePeca.findById(id);
								
							}
							@PostMapping("/Gravar")
							@ResponseStatus(HttpStatus.CREATED)
							public ControlePecaEntity gravarPeças(@RequestBody ControlePecaEntity controleP) {
								return controlePeca.save(controleP);
								
							}
							
							@PutMapping("/Atualizar/{id}")
							@ResponseStatus(HttpStatus.OK)
							public ControlePecaEntity atualizarPeças(@RequestBody ControlePecaEntity controleP) {
								
								return controlePeca.save(controleP);
								
							}
							@DeleteMapping("/Deletar/{id}")
							@ResponseStatus(HttpStatus.OK)
							public String deletarPeças(@PathVariable Integer id) {
								
								if (controlePeca.existsById(id)) {
									controlePeca.deleteById(id);
										return "Usuario deletado com sucesso!";
								}
								return "Usuario não encontrado!";
								
								}
		
}
