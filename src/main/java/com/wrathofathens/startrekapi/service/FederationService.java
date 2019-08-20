package com.wrathofathens.startrekapi.service;

import com.wrathofathens.startrekapi.entity.Federation;

import java.util.List;

/**
 * FederationService
 */
public interface FederationService {

    public List<Federation> findAll();

    public Federation findByRegistry(int theRegistry);

    public void save(Federation theFederation);

    public void deleteById(int theRegistry);
    
}