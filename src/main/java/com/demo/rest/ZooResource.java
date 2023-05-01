package com.demo.rest;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.ws.rs.core.Response;

@Path("zoo")
public class ZooResource {
	
	// Add a Zoo Data into the database
	@POST
	@Path("/addzoodata")
	@Produces(MediaType.APPLICATION_JSON)
	public Zoo addZoo(Zoo obj){
		
		Zoo zoo = new Zoo();
		zoo.setZooId(obj.getZooId());
		zoo.setZooName(obj.getZooName());
		zoo.setZooLocation(obj.getZooLocation());
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(zoo);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
		return zoo;
	}
	
	// Fetching the all data from the Database
	@GET
	@Path("/getzoodata")
	@Produces(MediaType.APPLICATION_JSON)
	public 	List<Zoo> getZooData(){
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<Zoo> zooList = session.createQuery("FROM Zoo").list();
		
	    return zooList;
	}
	
	//Count the total number of zoo into the database
	@GET
	@Path("/zoocount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getZooCount(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			@SuppressWarnings("deprecation")
			Long zoocount=(Long) session.createQuery("SELECT COUNT(*) FROM Zoo").uniqueResult();
			return Response.ok().entity(zoocount.intValue()).build();
		}catch (Exception e) {
		      e.printStackTrace();
		      return Response.serverError().build();
		}
	}
	
	//Update the Zoo Data
	@SuppressWarnings("deprecation")
	@PUT
	@Path("/zooupdate")
	@Produces(MediaType.APPLICATION_JSON)
	public Zoo updateZooData(Zoo zooobj) {
			
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =session.beginTransaction();
		try {
			Zoo zoo = session.get(Zoo.class,zooobj.getZooId());
			if(zoo!=null) {
				zoo.setZooName(zooobj.getZooName());
				zoo.setZooLocation(zooobj.getZooLocation());
				session.update(zoo);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return zooobj;
	}
	
	//Deleting the Zoo Data
	@DELETE
	@Path("/{zooId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteZoo(@PathParam("zooId") String zooId) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =null;
		
		try {
		    // Begin transaction
		    tx = session.beginTransaction();
		    
		    // Load the entity(Zoo entity) from the database
		    Zoo zooobj = session.get(Zoo.class, zooId);
		    
		    if(zooobj==null) {
		    	return Response.status(Response.Status.NOT_FOUND).build();
		    }
		    
		    // Delete the entity
		    session.delete(zooobj);
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
