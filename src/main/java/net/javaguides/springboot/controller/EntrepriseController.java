package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.springboot.model.Entreprise;
import net.javaguides.springboot.repository.EntrepriseRepository;


@Controller

public class EntrepriseController {
	
	@Autowired
	  private EntrepriseRepository entrepriseRepository;

	  @GetMapping("/entreprises")
	  public String getAll(Model model/*, @Param("keyword") String keyword*/) {
	    try {
	      List<Entreprise> entreprises = new ArrayList<Entreprise>();

	      //if (keyword == null) {
	        entrepriseRepository.findAll().forEach(entreprises::add);
	      /*} else {
	        entrepriseRepository.findByTitleContainingIgnoreCase(keyword).forEach(entreprises::add);
	        model.addAttribute("keyword", keyword);
	      }*/

	      model.addAttribute("entreprises", entreprises);
	    } catch (Exception e) {
	      model.addAttribute("message", e.getMessage());
	    }

	    return "entreprises";
	  }
	  

	  @GetMapping("/entreprises/new")
	  public String addEntreprise(Model model) {
	    Entreprise entreprise = new Entreprise();

	    model.addAttribute("entreprise", entreprise);
	    model.addAttribute("pageTitle", "Create new Entreprise");

	    return "entreprise_form";
	  }

	  @PostMapping("/entreprises/save")
	  public String saveEntreprise(Entreprise entreprise, RedirectAttributes redirectAttributes) {
	    try {
	      entrepriseRepository.save(entreprise);

	      redirectAttributes.addFlashAttribute("message", "The Entreprise has been saved successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addAttribute("message", e.getMessage());
	    }

	    return "redirect:/entreprises";
	  }

	  @GetMapping("/entreprises/{id}")
	  public String editEntreprise(@PathVariable("id") Long entID, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      Entreprise entreprise = entrepriseRepository.findById(entID).get();

	      model.addAttribute("entreprise", entreprise);
	      model.addAttribute("pageTitle", "Edit Entreprise (ID: " + entID + ")");

	      return "entreprise_form";
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());

	      return "redirect:/entreprises";
	    }
	  }

	  @GetMapping("/entreprises/delete/{id}")
	  public String deleteEntreprise(@PathVariable("id") Long entID, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      entrepriseRepository.deleteById(entID);

	      redirectAttributes.addFlashAttribute("message", "The Entreprise with id=" + entID + " has been deleted successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());
	    }

	    return "redirect:/entreprises";
	  }

}
