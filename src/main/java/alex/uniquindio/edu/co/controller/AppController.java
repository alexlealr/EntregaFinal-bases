package alex.uniquindio.edu.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador que permite acceder a los fomularios de login 
 * y principal
 * @author alexander leal
 *
 */
@Controller
public class AppController {
	
    /**
     * Metodo que permite redireccionar al formulario de login
     * @return index formulario login
     */
	@GetMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
    /**
     * Metodo que permite redireccionar al formulario principal de la app
     * @return home formulario principal
     */
	@GetMapping("/login")
	public String index() {
		return "index";
	}

}
