package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.ListaCanales;

public interface ListaCanalesService {

	boolean crearCanalesService(List<ListaCanales> listaCanales);
	boolean anadirCanaleServices(List<ListaCanales> listaCanales);
	List <ListaCanales> listarCanalesService();
}
