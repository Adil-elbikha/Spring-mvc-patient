package ma.emsi.springmvc.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.compiler.ast.Keyword;
import ma.emsi.springmvc.dao.PatientRepository;
import ma.emsi.springmvc.entities.Patient;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	@GetMapping(path = "/index")
	
	public String index() {
		
		return "index";
		
	}
	
	@GetMapping(path = "/patients")
	public String list(Model model, 
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size,
			@RequestParam(name="keyword",defaultValue="")String mc){
		Page<Patient> pagepatients=patientRepository.findByNameContains(mc,PageRequest.of(page, size));
			model.addAttribute("patients",pagepatients.getContent());
			model.addAttribute("pages",new int[pagepatients.getTotalPages()]);
			model.addAttribute("currentPage",page);
			model.addAttribute("keyword", mc);
			model.addAttribute("size", size);
		return "Patient";
		
	}
@GetMapping(path = "/deletePatient")
	
	public String delete(Long id,String keyword,int page,int size) {
	
		patientRepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&Keyword="+keyword;
		
	}

	
}
