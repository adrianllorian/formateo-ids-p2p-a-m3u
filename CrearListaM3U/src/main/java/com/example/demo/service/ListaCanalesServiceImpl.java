package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ListaCanales;
import com.example.demo.util.EscribirFichero;

@Service
public class ListaCanalesServiceImpl implements ListaCanalesService {
	
	@Autowired
	public EscribirFichero escribirFichero;

	@Override
	public boolean crearCanalesService(List<ListaCanales> listaCanales) {
		return escribirFichero.crearVariableM3U(listaCanales);
		
	}

	@Override
	public boolean anadirCanaleServices(List<ListaCanales> listaCanales) {
		return escribirFichero.anadirCanalesAVariableM3u(listaCanales);
	}

	@Override
	public List<ListaCanales> listarCanalesService() {
		// TODO Auto-generated metﬁhod stub
		return null;
	}

}
