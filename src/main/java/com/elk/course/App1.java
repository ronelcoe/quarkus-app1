package com.elk.course;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@Path("/hello")
public class App1 {
	
	private static final Logger logger = Logger.getLogger(App1.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	logger.info("Calling hello endpoint");
        return "Hello RESTEasy";
    }
    
    @GET
    @Path("/exception")
    @Produces(MediaType.TEXT_PLAIN)
    public String throwException() { 
    	Exception npe = new NullPointerException("Forcing an exception to be thrown");
    	logger.error("Forcing an exception to be thrown and send to log", npe);
    	return "Exception thrown";
    }
    

    public static void main(String[] main) {
    	App1 app = new App1();
    	app.throwException();
    }
}