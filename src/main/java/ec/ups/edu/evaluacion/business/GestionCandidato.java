package ec.ups.edu.evaluacion.business;

import java.util.List;

import ec.ups.edu.evaluacion.dao.CandidadoDAO;
import ec.ups.edu.evaluacion.modelo.Candidatos;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCandidato {
	@Inject
    private CandidadoDAO daoCandidato;

    
    public void crear(Candidatos candidato) throws Exception {
        if (candidato == null || candidato.getCedula() == null || candidato.getCedula().isEmpty()) {
            throw new Exception("El candidato o su cédula no son válidos.");
        }
        try {
        	daoCandidato.create(candidato);
        } catch (Exception e) {
            throw new Exception("Error al crear el candidato: " + e.getMessage());
        }
    }

    
    public Candidatos obtener(String cedula) throws Exception {
        if (cedula == null || cedula.isEmpty()) {
            throw new Exception("La cédula no es válida.");
        }
        Candidatos candidato = daoCandidato.read(cedula);
        if (candidato == null) {
            throw new Exception("Candidato no encontrado.");
        }
        return candidato;
    }

    
    public void actualizar(Candidatos candidato) throws Exception {
        if (candidato == null || candidato.getCedula() == null || candidato.getCedula().isEmpty()) {
            throw new Exception("El candidato o su cédula no son válidos.");
        }
        Candidatos existente = daoCandidato.read(candidato.getCedula());
        if (existente == null) {
            throw new Exception("El candidato no existe.");
        }
        try {
        	daoCandidato.update(candidato);
        } catch (Exception e) {
            throw new Exception("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    // Eliminar usuario
    public void eliminar(String cedula) throws Exception {
        if (cedula == null || cedula.isEmpty()) {
            throw new Exception("La cédula no es válida.");
        }
        Candidatos candidato = daoCandidato.read(cedula);
        if (candidato == null) {
            throw new Exception("El usuario no existe.");
        }
        try {
        	daoCandidato.delete(cedula);
        } catch (Exception e) {
            throw new Exception("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    // Listar todos los usuarios
    public List<Candidatos> listar() throws Exception {
        try {
            return daoCandidato.findAll();
        } catch (Exception e) {
            throw new Exception("Error al listar los usuarios: " + e.getMessage());
        }
    }

}
