package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class ObtenerFechaHoy {

	public String obtenerFechaHoy() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
		return dtf.format(LocalDateTime.now());
	}
}
