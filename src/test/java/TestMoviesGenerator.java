import config.ConfigManager;
import data_transfer.ImdbMovieDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMoviesGenerator {
    private static MoviesGenerator moviesGenerator;
    private static List<ImdbMovieDto> movieDtos;
    private static ImdbMovieDto firstMovie;

    @BeforeAll
    private static void setup(){
        File testFile = new File(ConfigManager.imdbFileLocation());
        MoviesGenerator moviesGenerator = new MoviesGenerator();
        movieDtos = moviesGenerator.generate(testFile);
        firstMovie = movieDtos.get(0);
    }

    @Test
    public void generatesCorrectNumber(){
        assertEquals( 3832, movieDtos.size());
    }

    @Test
    public void generatesCorrectTitle(){
        assertEquals( "Avatar", firstMovie.getTitle());
    }

    @Test
    public void generatesCorrectScore(){
        assertEquals( 7.9, firstMovie.getScore());
    }

    @Test
    public void generatesCorrectYear(){
        assertEquals( 2009, firstMovie.getYear());
    }

    @Test
    public void generatesCorrectRating(){
        assertEquals( "PG-13", firstMovie.getRating());
    }

    @Test
    public void generatesCorrectGenres(){
        String[] expected = {"Action", "Adventure", "Fantasy", "Sci-Fi"};
        assertArrayEquals( expected, firstMovie.getGenres());
    }


}