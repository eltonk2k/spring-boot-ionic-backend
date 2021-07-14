package com.br.projeto.springbootmc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projeto.springbootmc.domain.Estado;
import com.br.projeto.springbootmc.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}

}
