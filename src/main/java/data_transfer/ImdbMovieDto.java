package data_transfer;

import com.opencsv.bean.CsvBindByName;

import java.util.concurrent.atomic.AtomicInteger;

public class ImdbMovieDto {
    private static AtomicInteger idCount = new AtomicInteger(0);
    private final int id;

    public ImdbMovieDto() {
        id = idCount.incrementAndGet();
    }

    public ImdbMovieDto(int id, String title, double score, int year, int duration, String rating, long budget, String[] genres, int gross, String director, String actor1, String actor2, String actor3, String language, String country) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.budget = budget;
        this.genres = genres;
        this.gross = gross;
        this.director = director;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.language = language;
        this.country = country;
    }

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "score")
    private double score;

    @CsvBindByName(column = "year")
    private int year;

    @CsvBindByName(column = "duration")
    private int duration;

    @CsvBindByName(column = "rating")
    private String rating;

    @CsvBindByName(column = "budget")
    private long budget;

    @CsvBindByName(column = "genres")
    private String[] genres;

    @CsvBindByName(column = "gross")
    private int gross;

    @CsvBindByName(column = "director")
    private String director;

    @CsvBindByName(column = "actor1")
    private String actor1;

    @CsvBindByName(column = "actor2")
    private String actor2;

    @CsvBindByName(column = "actor3")
    private String actor3;

    @CsvBindByName(column = "language")
    private String language;

    @CsvBindByName(column = "country")
    private String country;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public long getBudget() {
        return budget;
    }

    public String[] getGenres() {
        return genres;//.split("\\|");
    }

    public int getGross() {
        return gross;
    }

    public String getDirector() {
        return director;
    }

    public String getActor1() {
        return actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public String getActor3() {
        return actor3;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }
}
