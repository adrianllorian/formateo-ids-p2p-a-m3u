package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.ListaCanales;
import com.example.demo.service.ListaCanalesService;

@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
	
	@Autowired
	public ListaCanalesService listaCanalesService;
	
	@PostMapping(value="/crearLista", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean crearLista(@RequestBody List <ListaCanales> listaCanales) {
		System.out.println("listaCanales lleda " + listaCanales.size());
		return listaCanalesService.crearCanalesService(listaCanales);
	}
	


	@PostMapping(value="/anadirCanales")
	public boolean nuevaLista(@RequestBody List <ListaCanales> listaCanales) {
		return listaCanalesService.anadirCanaleServices(listaCanales);
	}
	
	
}
