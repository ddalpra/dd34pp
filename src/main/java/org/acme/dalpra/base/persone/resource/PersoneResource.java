package org.acme.dalpra.base.persone.resource;

import java.util.List;

import org.acme.dalpra.base.persone.entity.Persone;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Singleton
public class PersoneResource {
    @Inject
    EntityManager em;

    public List<Persone> getPersone(){
        return em.createQuery("SELECT p FROM Persone p").getResultList();
    }

    public Persone getPersone(Long id){
        return em.find(Persone.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Persone addPersone(Persone persone){
        em.persist(persone);
        return persone;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updatePersone(Long id, Persone persone) {
        Persone updatePersone = em.find(Persone.class, id);

        if(updatePersone != null){
            updatePersone.setFirstName(persone.getFirstName());
            updatePersone.setLastName(persone.getLastName());
            updatePersone.setTaxIdCode(persone.getTaxIdCode());
        }else{
            throw new RuntimeException("Persona non trovata.");
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deletePersone(Long id){
        Persone persone = getPersone(id);
        em.remove(persone);
    }

}
