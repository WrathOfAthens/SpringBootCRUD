package com.wrathofathens.startrekapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.wrathofathens.startrekapi.dao.FederationDAO;
import com.wrathofathens.startrekapi.entity.Federation;

/**
 * FederationServiceImpl
 */
@Service
public class FederationServiceImpl implements FederationService {

    private FederationDAO federationDAO;

    @Autowired
    public FederationServiceImpl(FederationDAO theFederationDAO) {
        federationDAO = theFederationDAO;
    }

    @Override
    @Transactional
    public List<Federation> findAll() {
        return federationDAO.findAll();
    }

    @Override
    @Transactional
    public Federation findByRegistry(int theRegistry) {
        return federationDAO.findByRegistry(theRegistry);
    }

    @Override
    @Transactional
    public void save(Federation theFederation) {
        federationDAO.save(theFederation);
    }

    @Override
    @Transactional
    public void deleteById(int theRegistry) {
		federationDAO.deleteById(theRegistry);
	}

    
}