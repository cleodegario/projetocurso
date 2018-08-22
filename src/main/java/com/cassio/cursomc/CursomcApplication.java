package com.cassio.cursomc;

import com.cassio.cursomc.domain.*;
import com.cassio.cursomc.domain.enums.EnumEstadoPagamento;
import com.cassio.cursomc.domain.enums.EnumTipoCliente;
import com.cassio.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), e1, cliente);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), e2, cliente);

        Pagamento pagto1 = new PagamentoCartao(null, EnumEstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoBoleto(null, EnumEstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cliente.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));



    }
}
