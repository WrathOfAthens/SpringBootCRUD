package com.wrathofathens.startrekapi.rest;

import java.util.List;

import com.wrathofathens.startrekapi.dao.FederationDAO;
import com.wrathofathens.startrekapi.entity.Federation;
import com.wrathofathens.startrekapi.service.FederationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FederationRestController
 */
@RestController
@RequestMapping("/api")
public class FederationRestController {

    private FederationService federationService;

    @Autowired
    public FederationRestController(FederationService theFederationService) {
        federationService = theFederationService;
    }

    // expose endpoints
    @GetMapping("/federation")
    public List<Federation> findAll() {
        return federationService.findAll();
    }

    @GetMapping("/federation/{registry}")
    public Federation getShip(@PathVariable int registry) {
        
        Federation theFederation = federationService.findByRegistry(registry);

        if (theFederation == null) throw new RuntimeException("No ship with registry " + registry + " found");

        return theFederation;
    }

    @PostMapping("/federation")
    public Federation addShip(@RequestBody Federation theFederation) {

        federationService.save(theFederation);

        return theFederation;
    }


}