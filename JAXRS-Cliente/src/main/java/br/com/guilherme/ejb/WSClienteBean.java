package br.com.guilherme.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.guilherme.model.Song;


@Singleton
public class WSClienteBean {

    private static final String URI_BASE = "http://localhost:8080/JAXRS-Cliente/services/music";
    
    private Client wsClient;
    
    @PostConstruct
    public void setUp() {
    	wsClient = ClientBuilder.newClient();
    }
    
    public void destroy() {
    	if(wsClient != null) {
    		wsClient.close();
    	}
    }
    
    public List<Song> list(){
    	return wsClient
	    		.target(URI_BASE)
	    		.request()
	    		.get(new GenericType<List<Song>>() { });
    }
    
    public Song find(int songId) {
    	return wsClient
	    		.target(URI_BASE)
	    		.path(String.valueOf(songId))
	    		.request()
	    		.get(Song.class);
    }
    
    public Response delete(int songId) {
    	return wsClient
	    		.target(URI_BASE)
	    		.path(String.valueOf(songId))
	    		.request()
	    		.delete();
    }
    
    public Response create(Song song) {
    	return wsClient
	    		.target(URI_BASE)
	    		.request(MediaType.APPLICATION_JSON)
	    		.post(Entity.json(song));
    }
    
    public Response update(Song song) {
    	return wsClient
	    		.target(URI_BASE)
	    		.path(String.valueOf(song.getId()))
	    		.request(MediaType.APPLICATION_JSON)
	    		.put(Entity.json(song));
    }
    
}

