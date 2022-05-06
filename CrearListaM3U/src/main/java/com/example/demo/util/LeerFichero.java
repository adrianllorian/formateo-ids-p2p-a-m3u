package com.example.demo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class LeerFichero {
	/*
	public String getFichero() {
		 String linea;
		    String texto = "";
		    FileReader fr = null;
			try {
				fr = new FileReader("src//main//resources//templates//lista//Canales_AceStream.m3u");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    try {
		    	BufferedReader br = new BufferedReader(fr);
				while ((linea = br.readLine()) != null) {
				    texto += linea+"\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return texto;	
	}
	*/
}
