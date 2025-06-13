package br.edu.idp.cc.poo.dvdrental;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import br.edu.idp.cc.poo.dvdrental.dao.ActorDAO;
import br.edu.idp.cc.poo.dvdrental.model.Actor;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrentalPU");
        EntityManager em = emf.createEntityManager();

        ActorDAO dao = new ActorDAO(em);

        Actor novo = new Actor("Joao", "Silva");
        dao.insert(novo);

        dao.findAll().forEach(System.out::println);

        System.out.println("Buscando por nome:");
        var encontrados = dao.findByName("Joao");
        encontrados.forEach(System.out::println);

        System.out.println("Atualizando...");
        Actor ator = encontrados.get(0);
        ator.setLastName("Souza");
        dao.update(ator);

        System.out.println("Removendo...");
        dao.delete(ator.getActorId());

        em.close();
        emf.close();
    }
}
