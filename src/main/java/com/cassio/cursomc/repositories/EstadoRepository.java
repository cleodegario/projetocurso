package com.cassio.cursomc.repositories;

import com.cassio.cursomc.domain.Estado;
import com.cassio.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
