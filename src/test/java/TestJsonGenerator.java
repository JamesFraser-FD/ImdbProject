import com.fasterxml.jackson.databind.JsonNode;
import config.ConfigManager;
import data_transfer.ImdbMovieDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonGenerator {
    private static JsonGenerator jsonGenerator;
    private static ArrayList<ImdbMovieDto> testMovieDtos;

    @BeforeAll
    private static void setup(){
        jsonGenerator = new JsonGenerator();
        ImdbMovieDto testMovieDto = new ImdbMovieDto(1, "Avatar",7.9,2009,178,"PG-13",237000000, new String[]{"Action", "Adventure", "Fantasy", "Sci-Fi"},760505847,"James Cameron","CCH Pounder","Joel David Moore","Wes Studi","English","USA");
        testMovieDtos = new ArrayList<>();
        testMovieDtos.add(testMovieDto);
    }

    @Test
    public void generatesNothing(){
        JsonNode jsonNode = jsonGenerator.generateJson(new ArrayList<>());
        assertEquals(0,jsonNode.size());
    }

    @Test
    public void generatesOneMovieJson(){
        JsonNode jsonNode = jsonGenerator.generateJson(testMovieDtos);
        assertEquals(1,jsonNode.size());
    }
    @Test
    public void generatesOneMovie(){
        JsonNode jsonNode = jsonGenerator.generateJson(testMovieDtos);
        assertEquals("Avatar",jsonNode.get(0).get("title").asText());
    }



}