package com.cassio.cursomc.services;

import com.cassio.cursomc.domain.Categoria;
import com.cassio.cursomc.domain.Cliente;
import com.cassio.cursomc.repositories.CategoriaRepository;
import com.cassio.cursomc.repositories.ClienteRepository;
import com.cassio.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }


    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElse(null);
    }

}
