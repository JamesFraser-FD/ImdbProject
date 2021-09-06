package data_transfer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MovieSerialiser extends StdSerializer<ImdbMovieDto> {
    
    public MovieSerialiser() {
        this(null);
    }

    public MovieSerialiser(Class<ImdbMovieDto> t) {
        super(t);
    }

    @Override
    public void serialize(
            ImdbMovieDto imdbMovieDto, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", imdbMovieDto.getId());
        jsonGenerator.writeStringField("title", imdbMovieDto.getTitle());
        jsonGenerator.writeNumberField("imdb_rating", imdbMovieDto.getScore());
        jsonGenerator.writeNumberField("duration", imdbMovieDto.getDuration());
        jsonGenerator.writeStringField("rating", imdbMovieDto.getRating());
        jsonGenerator.writeNumberField("budget", imdbMovieDto.getBudget());

        jsonGenerator.writeFieldName("genres");
        jsonGenerator.writeStartArray();
        for (String genre : imdbMovieDto.getGenres()) {
            jsonGenerator.writeString(genre);
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeStringField("director", imdbMovieDto.getDirector());

        jsonGenerator.writeFieldName("actors");
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(imdbMovieDto.getActor1());
        jsonGenerator.writeString(imdbMovieDto.getActor2());
        jsonGenerator.writeString(imdbMovieDto.getActor3());
        jsonGenerator.writeEndArray();

        jsonGenerator.writeStringField("language", imdbMovieDto.getLanguage());
        jsonGenerator.writeStringField("country", imdbMovieDto.getCountry());

        jsonGenerator.writeEndObject();
    }
}