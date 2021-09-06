public class FormattedMovieDto {
    private final int id;
    private final String title;
    private final double imdbRating;
    private final int duration;
    private final String rating;
    private final long budget;
    private final String[] genres;
    private final String director;
    private final String[] actors;
    private final String language;
    private final String country;

    public FormattedMovieDto(int id, String title, double imdbRating, int duration, String rating, long budget, String[] genres, String director, String[] actors, String language, String country) {
        this.id = id;
        this.title = title;
        this.imdbRating = imdbRating;
        this.duration = duration;
        this.rating = rating;
        this.budget = budget;
        this.genres = genres;
        this.director = director;
        this.actors = actors;
        this.language = language;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getImdbRating() {
        return imdbRating;
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
        return genres;
    }

    public String getDirector() {
        return director;
    }

    public String[] getActors() {
        return actors;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }
}
