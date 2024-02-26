package org.acme.dalpra.base.persone.endpoint;

import java.util.List;

import org.acme.dalpra.base.persone.entity.Persone;
import org.acme.dalpra.base.persone.resource.PersoneResource;

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

@Path("/api/persone")
public class PersoneEndpoint {
    
    @Inject
    PersoneResource personeResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persone> getPersone(){
        return personeResource.getPersone();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persone getPersone(@PathParam("id") Long id){
        return personeResource.getPersone(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePersone(@PathParam("id") Long id, Persone persone) {
        personeResource.updatePersone(id, persone);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Persone addUser(Persone persone) {
        return personeResource.addPersone(persone);
    }

    @DELETE
    @Path("/{id}")
    public void deletePersone(@PathParam("id") Long id) {
        personeResource.deletePersone(id);
    }

}
