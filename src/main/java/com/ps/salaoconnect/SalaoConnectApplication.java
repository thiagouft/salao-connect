package com.ps.salaoconnect;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ps.salaoconnect.domain.Usuario;
import com.ps.salaoconnect.repositories.AgendarRepository;
import com.ps.salaoconnect.repositories.UsuarioRepository;

@SpringBootApplication
public class SalaoConnectApplication implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	AgendarRepository agendarRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SalaoConnectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "Thiago Silva", 'M', "thiagoufma@gmail.com", "123456");
		Usuario user2 = new Usuario(null, "Ivo Poentes", 'M', "ivoufma@gmail.com", "123456");
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2));
			
	}
	
}
