# IMDB Film Project

The aim of this project is to take a csv containing IMDB data and transform it into JSON.

## Tasks
CSV - extraction and review
1. All records that do not have a full data set must be excluded and NOT transferred
    1. All records that do not have a full data set should be logged to a log file or text file for review

JSON - Transformation and format
1. All movies should have a unique numeric ID
2. All movies will be returned in an Array/List containing a JSON object
3. The JSON must be structured as below:
```json
{
  "id": 1,
  "Title": "Film Title",
  "imdb_rating": 6.9,
  "duration": 156,
  "rating": "PG-13",
  "budget": 124000000,
  "genres": ["Crime", "Horror", "Mystery", "Thriller"],
  "director": "James Cameron",
  "actors": ["James Franco", "Kirsten Dunst"],
  "language": "English",
  "Country": "USA"
}
```

* "id": int,
* "Title": String,
* "imdb_rating": double,
* "duration": int,
* "rating": String,
* "budget": int,
* "genres": String Array/List,
* "director": String,
* "actors": String Array/List
* "language": String
* "Country": String

The CSV is provided in the resources folder of this project.

## Testing
Where possible applicable unit tests should be in place using JUnit.