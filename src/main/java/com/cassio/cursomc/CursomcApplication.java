package com.cassio.cursomc;

import com.cassio.cursomc.domain.*;
import com.cassio.cursomc.domain.enums.EnumTipoCliente;
import com.cassio.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public static void main(String[] args) {

        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado estado = new Estado(null, "Minas Gerais");
        Estado estado2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", estado);
        Cidade c2 = new Cidade(null, "São Paulo", estado2);
        Cidade c3 = new Cidade(null, "Campinas", estado2);

        estado.getCidades().add(c1);
        estado2.getCidades().addAll(Arrays.asList(c2, c3));


        estadoRepository.saveAll(Arrays.asList(estado, estado2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cliente = new Cliente(null, "Maria SIlva", "maria@gmail.com", "3638912377", EnumTipoCliente.PESSOA_FISICA);
        cliente.getTelefones().addAll(Arrays.asList("123456789", "987654321"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cliente, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente, c2);

        cliente.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.save(cliente);

        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    }
}
