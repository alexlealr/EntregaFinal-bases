package alex.uniquindio.edu.co.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import alex.uniquindio.edu.co.entity.Opcion;
import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.service.OpcionService;
import alex.uniquindio.edu.co.service.PreguntaService;
import alex.uniquindio.edu.co.service.UsuarioService;

@Controller
public class OpcionController {
	@Autowired
	OpcionService opcionService;

	@PostMapping("/crearOpcion")
	public String crearOpcion(Opcion op, Model model) throws Exception {
		
		opcionService.createOpcion(op);
		model.addAttribute("opcionForm", new Opcion());
		return "redirect:/preguntaForm";
		
	}
	
}
