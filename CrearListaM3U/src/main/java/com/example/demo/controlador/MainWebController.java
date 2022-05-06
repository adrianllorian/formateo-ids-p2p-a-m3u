package com.example.demo.controlador;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.util.EscribirFichero;

@Controller
public class MainWebController {

	@Autowired
	private EscribirFichero leerFichero;
	
	@GetMapping(value="/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index.html");
	    return modelAndView;
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/mitv.m3u" )
	public String txtResponse(HttpServletResponse response){
	    String fileName = "Canales_AcesSteam.m3u";
	    response.setHeader("Content-Disposition", "inline; filename=" + fileName);
	    String content = leerFichero.leerListaM3u();
	    return content;
	}
	
	
}
