import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import data_transfer.ImdbMovieDto;
import data_transfer.MovieSerialiser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;


public class JsonGenerator {
    private static final Logger logger = LogManager.getLogger(JsonGenerator.class);

    public JsonNode generateJson(List<ImdbMovieDto> movies) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("MovieSerialiser", new Version(1, 0, 0, null, null, null));
        module.addSerializer(ImdbMovieDto.class, new MovieSerialiser());
        mapper.registerModule(module);
        return mapper.valueToTree(movies);
    }
}
