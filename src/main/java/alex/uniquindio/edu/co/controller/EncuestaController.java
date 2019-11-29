package alex.uniquindio.edu.co.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import alex.uniquindio.edu.co.entity.Encuesta;
import alex.uniquindio.edu.co.service.EncuestaService;
import alex.uniquindio.edu.co.service.UsuarioService;




@Controller
public class EncuestaController {
	@Autowired
	EncuestaService usuarioService;
	/**
	 * Permite cargar el formulario de registro de usuario
	 * @param model
	 * @return  formulario usuario
	 */
	@GetMapping("/encuestaForm")
	public String EncuestaForm(Model model) {
		model.addAttribute("encuestaForm", new Encuesta());
		model.addAttribute("encuestaList", usuarioService.getAllUsers());
		model.addAttribute("listTab","active");
		return "encuesta/encuesta-view";
	}
	/**
     * Permite crear el usuario de acuerdo a los datos ingresado por 
     * el usuario
     * @param asig Entidad usuario
     * @param result 
     * @param model
     * @return formulario usuario
     */
	@PostMapping("/encuestaForm")
	public String createEncuesta(@Valid @ModelAttribute("encuestaForm")Encuesta asig, BindingResult result, ModelMap model) {
		//passwordEncoder = new BCryptPasswordEncoder();
		//asig.setPassword(passwordEncoder.encode(asig.getPassword()));
		//asig.setRole("ADMIN");
		if (result.hasErrors()) {
			model.addAttribute("encuestaForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			usuarioService.createEncuesta(asig);
			model.addAttribute("encuestaForm", new Encuesta());
			model.addAttribute("listTab","active");
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("userForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("encuestaList", usuarioService.getAllUsers());
		
		}
		}
	    	model.addAttribute("encuestaList", usuarioService.getAllUsers());
	    	return "encuesta/encuesta-view";
	}
	
	/**
	 * Setea los datos del usuario que el usuario selecciona para editar
	 * @param model
	 * @param id variable para identificar el usuario seleccionado
	 * @return formuario usuario
	 * @throws Exception
	 */
	@GetMapping("/editEncuesta/{id}")
	public String getEditEncuestaForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Encuesta asigToEdit = usuarioService.getEncuestaById(id);
	    model.addAttribute("encuestaForm", asigToEdit);
		model.addAttribute("encuestaList", usuarioService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "encuesta/encuesta-view";
	}
	
	 /**
     * Permite editar el usuario que el usuario seleccione
     * @param asig Entidad usuario
     * @param result
     * @param model
     * @return formulario usuario
     */
	@PostMapping("/editEncuesta")
	public String postEditEncuestaForm(@Valid @ModelAttribute("encuestaForm")Encuesta asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("encuestaForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				usuarioService.updateEncuesta(asig);
				model.addAttribute("encuestaForm", new Encuesta());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("encuestaForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("encuestaList", usuarioService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("encuestaList", usuarioService.getAllUsers());
		return "encuesta/encuesta-view";

	}

	  /**
     * Permite cancelar el usuario que el usuario ha elegido para
     * editar
     * @param model
     * @return formulario usuario
     */
	@GetMapping("/editEncuesta/cancel")
	public String cancelEditEncuesta(ModelMap model) {
		return "redirect:/encuestaForm";
	}
	
	/**
     * permite eliminar el usuario seleccionada
     * @param model
     * @param id del usuario a eliminar
     * @return formulario usuario
     */
	@GetMapping("/deleteEncuesta/{id}")
	public String deleteEncuesta(Model model, @PathVariable(name="id") Long id) {
		try {
		//	UsuarioService.deleteUsuario(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion","El usuario no puede ser eliminado");
		}
		return EncuestaForm(model);
	}

}
