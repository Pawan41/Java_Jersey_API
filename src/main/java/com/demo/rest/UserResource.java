package com.demo.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;


@Path("user")
public class UserResource {
	
	// Add a user Data into the database
	@POST
	@Path("/adduserdata")
	@Produces(MediaType.APPLICATION_JSON)
	 public User addUsers(User obj) {
		
		User user =new User();
		user.setUserId(obj.getUserId());
		user.setUserName(obj.getUserName());
		user.setPassword(obj.getPassword());
		user.setUserEmail(obj.getUserEmail());
		user.setRole(obj.getRole());
		user.setUserNumber(obj.getUserNumber());
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =session.beginTransaction();
		try {
			session.persist(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
		return user;
	  }
	
	// Fetching the all data from the Database
	@GET
	@Path("/getuserdata")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserData(){
				
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<User> userList = session.createQuery("FROM User").list();

		return userList;
	}
	
	// Count the Total number of Users into the Database
	@GET
	@Path("/usercount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserCount() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			@SuppressWarnings("deprecation")
			Long userCount=(Long) session.createQuery("SELECT COUNT(*) FROM User").uniqueResult();
			return Response.ok().entity(userCount.intValue()).build();
		}catch (Exception e) {
			  e.printStackTrace();
			  return Response.serverError().build();
		}
	}
			
	//Update the User Data
	@PUT
	@Path("/userupdate")
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUserData(User userobj) {
			
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =session.beginTransaction();
		try {
			session.merge(userobj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return userobj;
	}
	
	
	//Deleting the Zoo Data
	@DELETE
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("userId") String userId) {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			Transaction tx =null;
			
			try {
			    // Begin transaction
			    tx = session.beginTransaction();
			    
			    // Load the entity(Zoo entity) from the database
			    User userobj = session.get(User.class, userId);
			    
			    if(userobj==null) {
			    	return Response.status(Response.Status.NOT_FOUND).build();
			    }
			    
			    // Delete the entity
			    session.delete(userobj);
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
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User credentials) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    User user = session.createQuery(
	    	    "FROM User u WHERE u.userEmail = :email", User.class)
	    	    .setParameter("email", credentials.getUserEmail())
	    	    .uniqueResult();
	  
	    if (user != null && BCrypt.checkpw(credentials.getPassword(), user.getPassword())) {
	      return Response.ok(user).build();
	    } else {
	      return Response.status(Response.Status.UNAUTHORIZED).build();
	    }
	}
	
}
	