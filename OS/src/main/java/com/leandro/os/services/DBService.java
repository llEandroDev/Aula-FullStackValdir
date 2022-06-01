package com.leandro.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.os.domain.Cliente;
import com.leandro.os.domain.OS;
import com.leandro.os.domain.Tecnico;
import com.leandro.os.enuns.Prioridade;
import com.leandro.os.enuns.Status;
import com.leandro.os.repositories.ClienteRepository;
import com.leandro.os.repositories.OSRepository;
import com.leandro.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRposOsRepository;

	public void instanceDB() {

		Tecnico t1 = new Tecnico(null, "Leandro Alves", "985.338.960-69", "(88) 98888-8888");
		Cliente c1 = new Cliente(null, "Cristiane Alves", "241.175.490-65", "(88) 98888-8888");

		OS os1 = new OS(null, Prioridade.Alta, "Teste Cliente OS", Status.Andamento, t1, c1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRposOsRepository.saveAll(Arrays.asList(os1));

	}

}
