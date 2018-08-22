package com.cassio.cursomc.services;

import com.cassio.cursomc.domain.Categoria;
import com.cassio.cursomc.domain.Pedido;
import com.cassio.cursomc.repositories.CategoriaRepository;
import com.cassio.cursomc.repositories.PedidoRepository;
import com.cassio.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }


    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElse(null);
    }

}
