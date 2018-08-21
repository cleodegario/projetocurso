package com.cassio.cursomc.repositories;

import com.cassio.cursomc.domain.Categoria;
import com.cassio.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
