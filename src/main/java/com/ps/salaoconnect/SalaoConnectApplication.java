package com.ps.salaoconnect;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ps.salaoconnect.domain.Agendar;
import com.ps.salaoconnect.domain.Avaliacao;
import com.ps.salaoconnect.domain.Endereco;
import com.ps.salaoconnect.domain.Funcionario;
import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.domain.Servicos;
import com.ps.salaoconnect.domain.Usuario;
import com.ps.salaoconnect.repositories.AgendarRepository;
import com.ps.salaoconnect.repositories.AvaliacaoRepository;
import com.ps.salaoconnect.repositories.EnderecoRepository;
import com.ps.salaoconnect.repositories.FuncionarioRepository;
import com.ps.salaoconnect.repositories.SalaoRepository;
import com.ps.salaoconnect.repositories.ServicosRepository;
import com.ps.salaoconnect.repositories.UsuarioRepository;

@SpringBootApplication
public class SalaoConnectApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AgendarRepository agendarRepository;
	
	@Autowired
	private SalaoRepository salaoRepository;
	
	@Autowired
	private ServicosRepository servicosRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SalaoConnectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "Thiago Silva", 'M', "thiagoufma@gmail.com", "123456");
		Usuario user2 = new Usuario(null, "Ivo Poentes", 'M', "ivoufma@gmail.com", "123456");
		
		Salao salao1 = new Salao(null, "Barbearia Pereira", true, "Thiago Silva Pereira", "99999999");
		Salao salao2 = new Salao(null, "Barbearia Orion Six", true, "Orion Six", "11111111111");
		
		Servicos serv1 = new Servicos(null, "Cabelo e Barba", (float) 12.5, 45, salao1);
		Servicos serv2 = new Servicos(null, "Corte", 15, 30, salao1);
		Servicos serv3 = new Servicos(null, "Cabelo e Barba", (float) 12.5, 45, salao2);
		Servicos serv4 = new Servicos(null, "Corte", 15, 30, salao2);
		
		salao1.getServicos().addAll(Arrays.asList(serv1, serv2));
		salao2.getServicos().addAll(Arrays.asList(serv3,serv4));
		
		Endereco end1 = new Endereco(null, "Quadra 305 Norte", "250", "Proximo ao bar Real", "Plano Diretor Norte", "770012", salao1);
		Endereco end2 = new Endereco(null, "Areny III", "2123", "Proximo do Mar", "Plano Diretor Sul", "120012", salao2);
		
		salao1.getEnderecos().addAll(Arrays.asList(end1));
		salao2.getEnderecos().addAll(Arrays.asList(end2));
		
		Funcionario func1 = new Funcionario(null, "Jose de Assis", 44, "123456", salao1);
		Funcionario func2 = new Funcionario(null, "Pedro de Assis", 44, "123456", salao1);
		Funcionario func3 = new Funcionario(null, "Matheus de Assis", 44, "123456", salao2);
		Funcionario func4 = new Funcionario(null, "Six Six de Assis", 44, "123456", salao2);
		
		salao1.getFuncionarios().addAll(Arrays.asList(func1,func2));
		salao2.getFuncionarios().addAll(Arrays.asList(func3,func4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Agendar agd1 = new Agendar(null, sdf.parse("30/09/2017 10:32"), "Pendente", "Cartão",user1,serv1);
		Agendar agd2 = new Agendar(null, sdf.parse("30/09/2017 10:32"), "Pendente", "A Vista",user2,serv3);
		
		serv1.getAgendas().addAll(Arrays.asList(agd1));
		serv3.getAgendas().addAll(Arrays.asList(agd2));
		
		Avaliacao aval1 = new Avaliacao(null, "Muito bom o serviço", 5, agd1, serv1);
		Avaliacao aval2 = new Avaliacao(null, "Serviço mais ou menos", 3, agd2, serv3);
		
		serv1.getAvaliacao().addAll(Arrays.asList(aval1));
		serv3.getAvaliacao().addAll(Arrays.asList(aval2));
				
		
		
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2));
		salaoRepository.saveAll(Arrays.asList(salao1,salao2));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		servicosRepository.saveAll(Arrays.asList(serv1,serv2,serv3,serv4));
		funcionarioRepository.saveAll(Arrays.asList(func1,func2,func3,func4));
		agendarRepository.saveAll(Arrays.asList(agd1,agd2));
		avaliacaoRepository.saveAll(Arrays.asList(aval1,aval2));
			
	}
	
}
