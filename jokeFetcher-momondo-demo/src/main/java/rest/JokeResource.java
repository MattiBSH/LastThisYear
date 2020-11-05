package rest;

import DTOs.ChuckDTO;
import DTOs.DadDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;
import static utils.HttpUtils.fetchData;

/**
 * REST Web Service
 *
 * @author lam
 */
@Path("jokes")
public class JokeResource {

    @Context
    private UriInfo context;
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);
        OurDTO combinedDTO = new OurDTO(dadDTO,chuckDTO);
        return gson.toJson(combinedDTO);

    }

   
}
