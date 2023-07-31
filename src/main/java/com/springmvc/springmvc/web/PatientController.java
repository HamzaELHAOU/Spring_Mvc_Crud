package com.springmvc.springmvc.web;

import com.springmvc.springmvc.dao.PatientRepository;
import com.springmvc.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String index() {
        return "index";
    }

    // une methode retourner tous les patients

    @GetMapping(path = "/patients")

   /* public  String ListPatients(Model model, @RequestParam(name="page", defaultValue = "0") int page ,
                                @RequestParam(name="size", defaultValue = "6") int size){
        Page<Patient> patients =patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("patients",patients.getContent());
        model.addAttribute("pages",new int[patients.getTotalPages()]);
        return "listeP";
    } */


    //fonction de recherche par un mot clé et le mot clé prends par defaut une chaine vide donc afficher tous les patieins au début
    public String ListPatients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "4") int size,
                               @RequestParam(name = "NameChercher", defaultValue = "") String mc) {
        Page<Patient> patients = patientRepository.findAllByNameContains(mc, PageRequest.of(page, size));
        model.addAttribute("patients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("NameChercher", mc);
        model.addAttribute("pagecurrent", page);
        model.addAttribute("size", size);
        return "listeP";

    }


    //fonction permet de supprimer un patient
    @GetMapping(path = "/deletePage")
    public String delete(Long id, String mc, int page, int size) {
        patientRepository.deleteById(id);
        return "redirect:/patients?page=" + page + "&size=" + size + "&NameChercher=" + mc;
    }

    @GetMapping(path = "/FormulaireAjouter")
    public String AjouterPage() {
        return "AjouterPatients";
    }


    @PostMapping(path = "/savePatient")
    public String Save(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/index";
    }


    @GetMapping(path = "/editPatient")
    public String Edit(Long id, Model model) {
        Patient p = patientRepository.findById(id).get();
        model.addAttribute("patientedit", p);
        return "editPatients";
    }


    @GetMapping(path = "/json")
    @ResponseBody
    public List<Patient> jsonList() {

        return patientRepository.findAll();
    }

}