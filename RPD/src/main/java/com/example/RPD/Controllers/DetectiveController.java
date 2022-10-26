package com.example.RPD.Controllers;

import com.example.RPD.Repository.CaseParticipatorRepository;
import com.example.RPD.Repository.ClueRepository;
import com.example.RPD.Repository.CrimeCaseRepository;
import com.example.RPD.Repository.TestimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@PreAuthorize("hasAnyAuthority('DETECTIVE')")
public class DetectiveController {
    @Autowired
    CaseParticipatorRepository caseParticipatorRepository;
    @Autowired
    CrimeCaseRepository crimeCaseRepository;
    @Autowired
    TestimonyRepository testimonyRepository;
    @Autowired
    ClueRepository clueRepository;

    //Testimony


}
