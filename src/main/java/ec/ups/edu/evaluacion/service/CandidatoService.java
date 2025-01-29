package ec.ups.edu.evaluacion.service;


import ec.ups.edu.evaluacion.business.GestionCandidato;
import ec.ups.edu.evaluacion.modelo.Candidatos;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/candidatos")
public class CandidatoService {
	@Inject
    private GestionCandidato gCandidatos;

    // Crear un nuevo usuario
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Candidatos candidato) {
        try {
        	gCandidatos.crear(candidato);
            Respuesta respuesta = new Respuesta(Respuesta.OK, "Usuario creado exitosamente.");
            return Response.status(Response.Status.CREATED).entity(respuesta).build();
        } catch (Exception e) {
            Respuesta respuesta = new Respuesta(Respuesta.ERROR, e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }

    // Obtener usuario por cédula
    @GET
    @Path("/{cedula}")
    @Produces("application/json")
    public Response obtener(@PathParam("cedula") String cedula) {
        try {
        	Candidatos candidato = gCandidatos.obtener(cedula);
            return Response.status(Response.Status.OK).entity(candidato).build();
        } catch (Exception e) {
            Respuesta respuesta = new Respuesta(Respuesta.ERROR, e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(respuesta).build();
        }
    }

    // Actualizar usuario
    @PUT
    @Path("/{cedula}")
    @Produces("application/json")
    public Response actualizar(@PathParam("cedula") String cedula, Candidatos candidato) {
        try {
            if (!candidato.getCedula().equals(cedula)) {
                throw new IllegalArgumentException("La cédula no coincide.");
            }
            gCandidatos.actualizar(candidato);
            Respuesta respuesta = new Respuesta(Respuesta.OK, "Usuario actualizado exitosamente.");
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (Exception e) {
            Respuesta respuesta = new Respuesta(Respuesta.ERROR, e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }

    // Eliminar usuario
    @DELETE
    @Path("/{cedula}")
    @Produces("application/json")
    public Response eliminar(@PathParam("cedula") String cedula) {
        try {
        	gCandidatos.eliminar(cedula);
            Respuesta respuesta = new Respuesta(Respuesta.OK, "Usuario eliminado exitosamente.");
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (Exception e) {
            Respuesta respuesta = new Respuesta(Respuesta.ERROR, e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }

    // Listar todos los usuarios
    @GET
    @Produces("application/json")
    public Response listar() {
        try {
            return Response.status(Response.Status.OK).entity(gCandidatos.listar()).build();
        } catch (Exception e) {
            Respuesta respuesta = new Respuesta(Respuesta.ERROR, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
        }
    }

}
