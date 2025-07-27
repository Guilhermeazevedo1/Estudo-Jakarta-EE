package br.com.guilherme.config;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.guilherme.model.Song;
import br.com.guilherme.model.Songs;

@Path("/music")
public class MusicService {
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Song> loadSongsAsJson(){
		return Songs.list();
	}
	
	@GET
	@Path("/{songId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Song loadById(@PathParam("songId") int id) {
		return Songs.findById(id);
	}
	
	
	// esse metodo serve para você buscar por queryString, no caso no própria barra de pesquisa exemplo find?songId=1
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Song loadByIdQuery(@QueryParam("songId") int id) {
		return Songs.findById(id);
	}
}
