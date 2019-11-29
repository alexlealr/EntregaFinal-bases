/**
 * 
 */
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

import alex.uniquindio.edu.co.entity.Pregunta;
import alex.uniquindio.edu.co.entity.PreguntaEncuesta;
import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.service.EncuestaService;
import alex.uniquindio.edu.co.service.PreguntaService;
import alex.uniquindio.edu.co.service.UsuarioService;



/**
 * @author PERSONAL
 *
 */
@Controller
public class PreguntaController {
	
	
	/**
	 * Servicio usuario en el cual se encuentran los metodos pertinentes al crud
	 * de usuario
	 */
	@Autowired
	PreguntaService preguntaService;
	@Autowired
	EncuestaService encuesta;
	
	/**
	 * Servicio para encriptar las contraseñas que registre el usuario
	 */



	/**
	 * Permite cargar el formulario de registro de usuario
	 * @param model
	 * @return  formulario usuario
	 */
	@GetMapping("/preguntaForm")
	public String PreguntaForm(Model model, Model model2) {
		model.addAttribute("preguntaForm", new Pregunta());
		model.addAttribute("preguntaForm", new PreguntaEncuesta());
		model.addAttribute("preguntaList", preguntaService.getAllUsers());
		model.addAttribute("encuestas", encuesta.getAllUsers());
		model.addAttribute("listTab","active");
		return "pregunta/pregunta-view";
	}
	/**
     * Permite crear el usuario de acuerdo a los datos ingresado por 
     * el usuario
     * @param asig Entidad usuario
     * @param result 
     * @param model
     * @return formulario usuario
     */
	@PostMapping("/preguntaForm")
	public String createPregunta(@Valid @ModelAttribute("preguntaForm")Pregunta asig, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("preguntaForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			   System.out.println("puta"+asig.getPregunta());
			preguntaService.createPregunta(asig);
			model.addAttribute("preguntaForm", new Pregunta());
			model.addAttribute("listTab","active");
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("preguntaForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("preguntaList", preguntaService.getAllUsers());
		
		}
		}
	    	model.addAttribute("preguntaList", preguntaService.getAllUsers());
	    	return "pregunta/pregunta-view";
	}
	
	/**
	 * Setea los datos del usuario que el usuario selecciona para editar
	 * @param model
	 * @param id variable para identificar el usuario seleccionado
	 * @return formuario usuario
	 * @throws Exception
	 */
	@GetMapping("/editPregunta/{preguntaId}")
	public String getEditPreguntaForm(Model model, @PathVariable(name ="preguntaId")Long id)throws Exception{
		Pregunta asigToEdit = preguntaService.getPreguntaById(id);

		model.addAttribute("preguntaForm", asigToEdit);
		model.addAttribute("preguntaList", preguntaService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "pregunta/pregunta-view";
	}
	
	 /**
     * Permite editar el usuario que el usuario seleccione
     * @param asig Entidad usuario
     * @param result
     * @param model
     * @return formulario usuario
     */
	@PostMapping("/editPregunta")
	public String postEditPreguntaForm(@Valid @ModelAttribute("preguntaForm")Pregunta asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("preguntaForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				preguntaService.updatePregunta(asig);
				model.addAttribute("preguntaForm", new Pregunta());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("preguntaForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("preguntaList", preguntaService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("preguntaList", preguntaService.getAllUsers());
		return "pregunta/pregunta-view";

	}

	  /**
     * Permite cancelar el usuario que el usuario ha elegido para
     * editar
     * @param model
     * @return formulario usuario
     */
	@GetMapping("/editPregunta/cancel")
	public String cancelEditPregunta(ModelMap model) {
		return "redirect:/preguntaForm";
	}
	/**
     * permite eliminar el usuario seleccionada
     * @param model
     * @param id del usuario a eliminar
     * @return formulario usuario
     */
	@GetMapping("/deletePregunta/{id}")
	public String deletePregunta(Model model,Model model2, @PathVariable(name="id") Long id) {
		try {
			preguntaService.deletePregunta(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion","La pregunta no puede ser eliminado");
		}
		return PreguntaForm(model, model2);
	}
}
