import com.opencsv.bean.CsvToBeanBuilder;
import data_transfer.ImdbMovieDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MoviesGenerator {
    private static final Logger logger = LogManager.getLogger(MoviesGenerator.class);

    public List<ImdbMovieDto> generate(File fileName) {
        logger.info("Generating movies from " + fileName);

        List<ImdbMovieDto> movies = new ArrayList<>();
        AtomicInteger rejectedCounter = new AtomicInteger();

        try {
            movies = new CsvToBeanBuilder<ImdbMovieDto>(new FileReader(fileName))
                    .withType(ImdbMovieDto.class)
                    .withFilter(strings -> {
                        for (String entry : strings) {
                            if (entry == null || entry.length() == 0) {
                                logger.info("Incomplete record: " + Arrays.toString(strings));
                                rejectedCounter.getAndIncrement();
                                return false;
                            }
                        }
                        return true;
                    })
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        logger.info("Generated " + movies.size() + " movies from " + fileName + " (" + rejectedCounter + " rejected)");

        return movies;
    }
}
