import ConfigManagement.ConfigManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputGenerator {
    private static final Logger logger = LogManager.getLogger(OutputGenerator.class);

    public static void main(String[] args) {

        logger.info("Application Start");
        String fileName = ConfigManager.imdbFileLocation();
        MoviesGenerator generator = new MoviesGenerator();

        List<MovieDto> movies = generator.generate(fileName);
        List<FormattedMovieDto> formattedMovies = new ArrayList<>();

        MovieTransformer transformer = new MovieTransformer();
        movies.forEach(m -> formattedMovies.add(transformer.transform(m)));
        System.out.println(movies.size());
        System.out.println(formattedMovies.size());

        File outputFile = new File(ConfigManager.outputFileLocation());
        FileWriter writer;

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(formattedMovies.get(3831).getId());

        try {
            writer = new FileWriter(outputFile);
                String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(formattedMovies);
                writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Application End");

    }
}
