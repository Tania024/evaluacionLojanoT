package ec.ups.edu.evaluacion.dao;

import java.util.List;

import ec.ups.edu.evaluacion.modelo.Candidatos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CandidadoDAO {
	@PersistenceContext
    private EntityManager em;

    public void create(Candidatos candidato) {
        em.persist(candidato);
    }

    public Candidatos read(String cedula) {
        return em.find(Candidatos.class, cedula);
    }

    public void update(Candidatos candidato) {
        em.merge(candidato);
    }

    public void delete(String cedula) {
    	Candidatos candidato = read(cedula);
        if (candidato != null) {
            em.remove(candidato);
        }
    }

    public List<Candidatos> findAll() {
        String jpql = "SELECT c FROM Candidatos c";
        Query query = em.createQuery(jpql, Candidatos.class);
        return query.getResultList();
    }
	
}
