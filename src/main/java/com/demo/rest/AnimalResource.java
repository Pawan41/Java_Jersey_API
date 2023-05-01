package com.demo.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Path("animal")
public class AnimalResource {

	// Add a Animal Data into the database
	@POST
	@Path("/addanimaldata")
	@Produces(MediaType.APPLICATION_JSON)
	public Animal addAnimal(Animal obj) {
		
		Animal animal =new Animal();
		animal.setAnimalId(obj.getAnimalId());
		animal.setAnimalName(obj.getAnimalName());
		animal.setAnimalGender(obj.getAnimalGender());
		animal.setAnimalZooName(obj.getAnimalZooName());
	
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =session.beginTransaction();
		try {
			session.persist(animal);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return animal;
		
	}
	
	// Fetching the all data from the Database
	@GET
	@Path("/getanimaldata")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Animal> getAnimalData(){
			
		Session session=HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("deprecation")
		List<Animal> animalList = session.createQuery("FROM Animal").list();

		return animalList;
	}
	
	// Count the Total number of Animal into the Database
	@GET
	@Path("/animalcount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnimalCount() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			@SuppressWarnings("deprecation")
			Long animalCount=(Long) session.createQuery("SELECT COUNT(*) FROM Animal").uniqueResult();
			return Response.ok().entity(animalCount.intValue()).build();
		}catch (Exception e) {
		      e.printStackTrace();
		      return Response.serverError().build();
		}
	}
	
	
	//Update the Animal Data
	@PUT
	@Path("/animalupdate")
	@Produces(MediaType.APPLICATION_JSON)
	public Animal updateAnimalData(Animal animalobj) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =session.beginTransaction();
		try {
			// Fetch the animal object from the database using its id
			Animal animal= session.get(Animal.class,animalobj.getAnimalId());
			if(animal!=null) {
				animal.setAnimalName(animalobj.getAnimalName());
				animal.setAnimalGender(animalobj.getAnimalGender());
				animal.setAnimalZooName(animalobj.getAnimalZooName());
				session.update(animal);	
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return animalobj;
	}
	
	//Deleting the Animal Data
	@SuppressWarnings("deprecation")
	@DELETE
	@Path("/{animalId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAnimal(@PathParam("animalId") String animalId) {
			
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =null;
			
			try {
			    // Begin transaction
			    tx = session.beginTransaction();
			    
			    // Load the entity(Zoo entity) from the database
			    Animal animalobj = session.get(Animal.class, animalId);
			    
			    if(animalobj==null) {
			    	return Response.status(Response.Status.NOT_FOUND).build();
			    }
			    
			    // Delete the entity
			    session.delete(animalobj);
			    // Commit the transaction
			    tx.commit();
			    
			    return Response.ok().build();
			    
			}catch (Exception e) {
	            // Handle exception
	            session.getTransaction().rollback();
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	            
	        } finally {
	            // Close session
	            session.close();
	        }
		}
	
}
