package net.javaguides.springboot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.springboot.model.Etudiant;
import net.javaguides.springboot.repository.EtudiantRepository;

@Controller
public class EtudiantController {

  @Autowired
  private EtudiantRepository etudiantRepository;

  @GetMapping("/etudiants")
  public String getAll(Model model, @Param("keyword") String keyword) {
    try {
      List<Etudiant> etudiants = new ArrayList<Etudiant>();

      if (keyword == null) {
        etudiantRepository.findAll().forEach(etudiants::add);
      } else {
        etudiantRepository.findByNomContainingIgnoreCase(keyword).forEach(etudiants::add);
        model.addAttribute("keyword", keyword);
      }

      model.addAttribute("etudiants", etudiants);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "etudiants";
  }

  @GetMapping("/etudiants/new")
  public String addEtudiant(Model model) {
    Etudiant etudiant = new Etudiant();

    model.addAttribute("etudiant", etudiant);
    model.addAttribute("pageTitle", "Create new Etudiant");

    return "etudiant_form";
  }

  @PostMapping("/etudiants/save")
  public String saveEtudiant(Etudiant etudiant, RedirectAttributes redirectAttributes) {
    try {
      etudiantRepository.save(etudiant);

      redirectAttributes.addFlashAttribute("message", "The Etudiant has been saved successfully!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }

    return "redirect:/etudiants";
  }

  @GetMapping("/etudiants/{id}")
  public String editEtudiant(@PathVariable("id") Long etudID, Model model, RedirectAttributes redirectAttributes) {
    try {
      Etudiant etudiant = etudiantRepository.findById(etudID).get();

      model.addAttribute("etudiant", etudiant);
      model.addAttribute("pageTitle", "Edit Etudiant (ID: " + etudID + ")");

      return "etudiant_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());

      return "redirect:/etudiants";
    }
  }

  @GetMapping("/etudiants/delete/{id}")
  public String deleteEtudiant(@PathVariable("id") Long etudID, Model model, RedirectAttributes redirectAttributes) {
    try {
      etudiantRepository.deleteById(etudID);

      redirectAttributes.addFlashAttribute("message", "The Etudiant with id=" + etudID + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/etudiants";
  }


}
