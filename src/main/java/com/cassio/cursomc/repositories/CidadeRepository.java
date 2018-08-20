package com.cassio.cursomc.repositories;

import com.cassio.cursomc.domain.Cidade;
import com.cassio.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
