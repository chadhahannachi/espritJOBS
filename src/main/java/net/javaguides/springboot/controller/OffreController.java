package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.springboot.model.Offre;
import net.javaguides.springboot.repository.OffreRepository;

@Controller
public class OffreController {
	@Autowired
	  private OffreRepository offreRepository;

	  @GetMapping("/offres")
	  public String getAll(Model model) {
	    try {
	      List<Offre> offres = new ArrayList<Offre>();

	        offreRepository.findAll().forEach(offres::add);
	     

	      model.addAttribute("offres", offres);
	    } catch (Exception e) {
	      model.addAttribute("message", e.getMessage());
	    }

	    return "offres";
	  }

	  @GetMapping("/offres/new")
	  public String addOffre(Model model) {
	    Offre offre = new Offre();

	    model.addAttribute("offre", offre);
	    model.addAttribute("pageTitle", "Create new Offre");

	    return "offre_form";
	  }

	  @PostMapping("/offres/save")
	  public String saveOffre(Offre offre, RedirectAttributes redirectAttributes) {
	    try {
	      offreRepository.save(offre);

	      redirectAttributes.addFlashAttribute("message", "The Offre has been saved successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addAttribute("message", e.getMessage());
	    }

	    return "redirect:/offres";
	  }

	  @GetMapping("/offres/{id}")
	  public String editOffre(@PathVariable("id") Long offreID, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      Offre offre = offreRepository.findById(offreID).get();

	      model.addAttribute("offre", offre);
	      model.addAttribute("pageTitle", "Edit Offre (ID: " + offreID + ")");

	      return "offre_form";
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());

	      return "redirect:/offres";
	    }
	  }

	  @GetMapping("/offres/delete/{id}")
	  public String deleteOffre(@PathVariable("id") Long offreID, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      offreRepository.deleteById(offreID);

	      redirectAttributes.addFlashAttribute("message", "The Offre with id=" + offreID + " has been deleted successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());
	    }

	    return "redirect:/offres";
	  }

}
