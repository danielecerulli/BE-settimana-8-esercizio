package it.dipendenti.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.dipendenti.pojo.Dipendente;

@Path("/dipendenti")
public class GestioneDipendente {
	
	private static List<Dipendente> dipendenti = new ArrayList<Dipendente>();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Dipendente> retrieveDipendenti() {
		
		return dipendenti;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cancellaDipendente(Dipendente d) {
		
		for (Dipendente dip : dipendenti) {
			if (dip.getMatricola() == d.getMatricola()) {
				dipendenti.remove(dip);
				break;
			}
		}
		
		return Response.status(200).entity("Eliminazione avvenuta con successo").build();
	}
	
	@GET
	@Path("/{matricola}")
	@Produces(MediaType.APPLICATION_JSON)
	public Dipendente retrieveByPk(@PathParam("matricola")int matricola) {
		Dipendente d = null;
		for (Dipendente dip : dipendenti) {
			if (dip.getMatricola() == matricola) {
				d = dip;
			}
		}	
		return d;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserisciDipendente(Dipendente d) {
		dipendenti.add(d);
		return Response.status(200).entity("Inserimento avvenuto con successo").build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiornaDipendente(Dipendente d) {
		
		for (Dipendente dip : dipendenti) {
			if (dip.getMatricola() == d.getMatricola()) {
				int index = dipendenti.lastIndexOf(dip);
				dipendenti.set(index, d);
			}
		}
		
		return Response.status(200).entity("Aggiornamento avvenuto con successo").build();		
	}

}
