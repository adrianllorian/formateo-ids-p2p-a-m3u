package com.example.demo.seguridad;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import static com.example.demo.util.CosntantesSeguriad.*;


@Service
public class Autenticacion implements UserDetailsService {
	


	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario user = new Usuario(USUARIO_PARA_EL_ADMIN, CONTRASEÑA_PARA_EL_ADMIN, "admin");
		if(user.getNombre().equals(nombre)) {
			return user; 
		}
		else {
			throw new  UsernameNotFoundException("" + nombre);
			
		}
		
	}

}