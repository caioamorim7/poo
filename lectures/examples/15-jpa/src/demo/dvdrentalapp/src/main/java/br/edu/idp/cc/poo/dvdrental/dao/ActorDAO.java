package br.edu.idp.cc.poo.dvdrental.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.model.Actor;

public class ActorDAO {

    private final EntityManager em;

    public ActorDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Actor actor) {
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        AuditLogger.log("INSERT", "Ator inserido: " + actor);
    }

    public List<Actor> findAll() {
        return em.createQuery("SELECT a FROM Actor a ORDER BY a.actorId", Actor.class).getResultList();
    }

    public Actor findById(int id) {
        return em.find(Actor.class, id);
    }

    public List<Actor> findByName(String name) {
        return em.createQuery("SELECT a FROM Actor a WHERE a.firstName LIKE :name OR a.lastName LIKE :name", Actor.class)
                 .setParameter("name", "%" + name + "%")
                 .getResultList();
    }

    public void update(Actor actor) {
        em.getTransaction().begin();
        em.merge(actor);
        em.getTransaction().commit();
        AuditLogger.log("UPDATE", "Ator atualizado: " + actor);
    }

    public void delete(int id) {
        Actor actor = em.find(Actor.class, id);
        if (actor != null) {
            em.getTransaction().begin();
            em.remove(actor);
            em.getTransaction().commit();
            AuditLogger.log("DELETE", "Ator removido: " + actor);
        }
    }
}
