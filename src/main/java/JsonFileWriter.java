import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {
    private static final Logger logger = LogManager.getLogger(JsonFileWriter.class);

    public void writeJsonFile(File outputFile, JsonNode object) {
        logger.info("Writing JSON to " + outputFile);

        FileWriter writer;
        ObjectMapper mapper = new ObjectMapper();

        try {
            writer = new FileWriter(outputFile);
                String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
                writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
