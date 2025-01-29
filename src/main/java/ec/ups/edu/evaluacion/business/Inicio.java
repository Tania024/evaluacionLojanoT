package ec.ups.edu.evaluacion.business;

import java.util.List;

import ec.ups.edu.evaluacion.dao.CandidadoDAO;
import ec.ups.edu.evaluacion.modelo.Candidatos;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private CandidadoDAO daoCandidato;
    
    @PostConstruct
    public void init() {
        System.out.println("Inicializando datos...");

        Candidatos c = new Candidatos();
        c.setCedula("0106717671");
        c.setNombreCandidatos("Tania Lojano");
        c.setPartido("Corazon");
        c.setPropuesta("Tener agua limpia");
        daoCandidato.create(c);
      
        
        List<Candidatos> listado = daoCandidato.findAll();
        for (Candidatos ca : listado) {
            System.out.println(ca.getCedula() + " " + ca.getNombreCandidatos() + " " + ca.getPartido() + " " + ca.getPropuesta());
        }
    }    

}
