package com.wrathofathens.startrekapi.dao;

import java.util.List;
import com.wrathofathens.startrekapi.entity.Federation;
/**
 * FederationDAO
 */
public interface FederationDAO {

    public List<Federation> findAll();

    public Federation findByRegistry(int theRegistry);

    public void save(Federation theFederation);

    public void deleteById(int theRegistry);

}