import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviesGenerator {
    private static final Logger logger = LogManager.getLogger(MoviesGenerator.class);

    public List<MovieDto> generate(String fileName) {
        logger.info("Application Start");
        List<MovieDto> movies = new ArrayList<>();

        try {
            movies = new CsvToBeanBuilder<MovieDto>(new FileReader(fileName))
                    .withType(MovieDto.class)
                    .withFilter(strings -> {
                        for (String entry : strings) {
                            if (entry == null || entry.length() == 0) {
                                logger.info("Incomplete record: " + Arrays.toString(strings));
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

        return movies;
    }
}
