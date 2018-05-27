package com.ps.salaoconnect;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ps.salaoconnect.domain.Agendar;
import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.domain.Servicos;
import com.ps.salaoconnect.domain.Usuario;
import com.ps.salaoconnect.repositories.AgendarRepository;
import com.ps.salaoconnect.repositories.SalaoRepository;
import com.ps.salaoconnect.repositories.ServicosRepository;
import com.ps.salaoconnect.repositories.UsuarioRepository;

@SpringBootApplication
public class SalaoConnectApplication implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	AgendarRepository agendarRepository;
	
	@Autowired
	SalaoRepository salaoRepository;
	
	@Autowired
	ServicosRepository servicosRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SalaoConnectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "Thiago Silva", 'M', "thiagoufma@gmail.com", "123456");
		Usuario user2 = new Usuario(null, "Ivo Poentes", 'M', "ivoufma@gmail.com", "123456");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Agendar agd1 = new Agendar(null, sdf.parse("30/09/2017 10:32"), "Pendente", "Cartão");
		
		Salao salao1 = new Salao(null, "Barbearia Pereira", true, "Thiago Silva Pereira", "99999999");
		
		Servicos serv1 = new Servicos(null, "Salão maluco", (float) 12.5, 45, salao1);
		Servicos serv2 = new Servicos(null, "Corte", 15, 30, salao1);
		
		salao1.getServicos().addAll(Arrays.asList(serv1, serv2));
		
		
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2));
		//agendarRepository.saveAll(Arrays.asList(agd1));
		salaoRepository.saveAll(Arrays.asList(salao1));
		servicosRepository.saveAll(Arrays.asList(serv1,serv2));
		
			
	}
	
}
