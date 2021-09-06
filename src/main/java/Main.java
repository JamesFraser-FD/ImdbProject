import com.fasterxml.jackson.databind.JsonNode;
import config.ConfigManager;
import data_transfer.ImdbMovieDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application Start");

        // Load IMDB data
        File file = new File(ConfigManager.imdbFileLocation());
        MoviesGenerator generator = new MoviesGenerator();
        List<ImdbMovieDto> movies = generator.generate(file);

        // Serialise to JSON
        JsonGenerator jsonGenerator = new JsonGenerator();
        JsonNode node = jsonGenerator.generateJson(movies);

        // Output JSON
        File outputFile = new File(ConfigManager.outputFileLocation());
        JsonFileWriter jsonFileWriter = new JsonFileWriter();
        jsonFileWriter.writeJsonFile(outputFile, node);

        logger.info("Application End");
    }
}
