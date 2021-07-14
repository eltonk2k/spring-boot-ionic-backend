package com.br.projeto.springbootmc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.projeto.springbootmc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();
}
