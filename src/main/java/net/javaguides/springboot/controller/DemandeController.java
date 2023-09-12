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

import net.javaguides.springboot.model.Demande;
import net.javaguides.springboot.repository.DemandeRepository;

@Controller
public class DemandeController {
	@Autowired
	private DemandeRepository demandeRepository;

	  @GetMapping("/demandes")
	  public String getAll(Model model) {
	    try {
	      List<Demande> demandes = new ArrayList<Demande>();

	        demandeRepository.findAll().forEach(demandes::add);
	     

	      model.addAttribute("demandes", demandes);
	    } catch (Exception e) {
	      model.addAttribute("message", e.getMessage());
	    }

	    return "demandes";
	  }

	  @GetMapping("/demandes/new")
	  public String addDemande(Model model) {
	    Demande demande = new Demande();

	    model.addAttribute("demande", demande);
	    model.addAttribute("pageTitle", "Create new Demande");

	    return "demande_form";
	  }

	  @PostMapping("/demandes/save")
	  public String saveDemande(Demande demande, RedirectAttributes redirectAttributes) {
	    try {
	      demandeRepository.save(demande);

	      redirectAttributes.addFlashAttribute("message", "The Demande has been saved successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addAttribute("message", e.getMessage());
	    }

	    return "redirect:/demandes";
	  }

	  @GetMapping("/demandes/{id}")
	  public String editDemande(@PathVariable("id") Long demandeID, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      Demande demande = demandeRepository.findById(demandeID).get();

	      model.addAttribute("demande", demande);
	      model.addAttribute("pageTitle", "Edit Demande (ID: " + demandeID + ")");

	      return "demande_form";
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());

	      return "redirect:/demandes";
	    }
	  }

	  @GetMapping("/demandes/delete/{id}")
	  public String deleteDemande(@PathVariable("id") Long demandeID, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      demandeRepository.deleteById(demandeID);

	      redirectAttributes.addFlashAttribute("message", "The Demande with id=" + demandeID + " has been deleted successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());
	    }

	    return "redirect:/demandes";
	  }

}
