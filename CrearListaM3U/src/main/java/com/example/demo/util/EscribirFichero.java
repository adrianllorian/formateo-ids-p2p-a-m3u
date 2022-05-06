package com.example.demo.util;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.ListaCanales;

@Service
public class EscribirFichero {
	
	
	private String ficheroM3u;
	
	public boolean  crearVariableM3U(List <ListaCanales> listaCanales) {
		ficheroM3u ="";
		System.out.println("Contenido de la variable antes de crear los nuevos canales" + ficheroM3u);
		String salida = "#EXTM3U ";
		int contador = 0;
		for(ListaCanales canal : listaCanales) {
			if(!canal.getTitulo().equals(null)) {
				salida = salida + "\n #EXTINF:" + contador *-1 + " ,"+ canal.getTitulo() + "\n" + canal.getEnlace() + "\n";
				contador = contador +1;
			}
			
		}
		listaCanales.clear();
		ficheroM3u = salida;;
		return true;
	}
	
	public boolean  anadirCanalesAVariableM3u(List <ListaCanales> listaCanales) {
		String salida = ficheroM3u;
		int contador = 0;
		for(ListaCanales canal : listaCanales) {
			if(!canal.getTitulo().equals(null)) {
				salida = salida + "\n #EXTINF:" + contador *-1 + " ,"+ canal.getTitulo() + "\n" + canal.getEnlace() + "\n";
				contador = contador +1;
			}
			
		}
		ficheroM3u = salida;
		return true;
	}
	
	public void borrarVariableM3U() {
		ficheroM3u = "";
	}
	
	public String leerListaM3u() {
		return ficheroM3u;
	}
	
	
	//private File fichero = new File ("src//main//resources//templates//lista", "Canales_AceStream.m3u");
	/*
	public boolean escribirFichero(String canalesFormateados) {
		try {
			  // A partir del objeto File creamos el fichero físicamente
			FileWriter fw = new FileWriter(fichero, true);
          	BufferedWriter bw = new BufferedWriter(fw);
          	bw.write(canalesFormateados);
          	bw.close();				  
			return true;
			  
			} catch (Exception e) {
			 return false;
			}
	}
	
	public boolean borrarFichero() {
		return fichero.delete();
	}

	*/
}



