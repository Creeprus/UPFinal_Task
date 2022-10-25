package com.example.RPD.Controllers;

import com.example.RPD.Models.*;
import com.example.RPD.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/Policeman")
@PreAuthorize("hasAnyAuthority('OFFICER')")
public class PolicemanController {
    @Autowired
    CaseParticipatorRepository caseParticipatorRepository;
    @Autowired
    CaseParticipantCategoryRepository caseParticipantCategoryRepository;
    @Autowired
    CrimeCaseRepository crimeCaseRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/CrimeCase/CrimeCaseView")
    public String CrimeCase(Model model)
    {
        Iterable<CrimeCase> listCase= crimeCaseRepository.findAll();
        model.addAttribute("listCase",listCase);
        return "/Policeman/CrimeCase/CrimeCaseView";
    }
    @GetMapping("/CrimeCase/CrimeCaseAdd")
    public String CrimeCaseAddView(Model model, Employee employee)
    {

        Iterable<Employee> listEmp=employeeRepository.findAll();


        model.addAttribute("listEmp",listEmp);

        return "/Policeman/CrimeCase/CrimeCaseAdd";
    }
    @PostMapping("/CrimeCase/CrimeCaseAdd")
    public String CrimeCaseAdd(
            @Valid CrimeCase crimeCase,
            @RequestParam Long listEmp,
            BindingResult bindingResult,
            Model model)
    {

        if(bindingResult.hasErrors())
        {
            return "/Policeman/CrimeCase/CrimeCaseAdd";
        }
        crimeCase.setEmployee(employeeRepository.findById(listEmp).orElseThrow());
        crimeCaseRepository.save(crimeCase);


        return "redirect:/Policeman/CrimeCase/CrimeCaseView";
    }
}
