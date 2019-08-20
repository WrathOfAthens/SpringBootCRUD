package com.wrathofathens.startrekapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wrathofathens.startrekapi.entity.Federation;

/**
 * FederationDAOHibernateImpl
 * Constructor injection
 */
@Repository
public class FederationDAOHibernateImpl implements FederationDAO {

    private EntityManager entityManager;

    @Autowired
    public FederationDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Federation> findAll() {
        
        // fetch hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        // create query using hibernate native
        Query<Federation> theQuery = currentSession.createQuery("from Federation", Federation.class);
        
        // execute query
        List<Federation> federations = theQuery.getResultList();

        //return results
        return federations;
    }

    @Override
    public Federation findByRegistry(int theRegistry) {
        
        Session currentSession = entityManager.unwrap(Session.class);

        Federation theFederation = currentSession.get(Federation.class, theRegistry);
        
        return theFederation;
    }

    @Override
    public void save(Federation theFederation) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theFederation);

    }

    @Override
    public void deleteById(int theRegistry) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Federation where id=:Registry");
        theQuery.setParameter("Registry", theRegistry);

        theQuery.executeUpdate();

    }

}