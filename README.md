# MOVIES-API
This is the backend application having rest api's which is exposed to frontend for fetching , creating, updating movies with actors and producers

# SQL Script :

There are no scripts I have used for tables as tables are created automatically by using Spring Data JPA.

1. I am using three table Movie , Actor and Producer which will be created automatically as I am using Spring Data JPA.
2. The relationship between these tables has been specified in the entity classes .
3. I have mapped Movie -> Actor as One to Many Relationship and Movie -> Producer as One to One and these relations are bidirectional.


# API Information :

Base Url : 'http://localhost:8085'

1. "/movies" : GET
    This APi is used to fetch the list of all movies with actor and producer information. It will return all the movies with details and each
    movie information consists of - Name, Date of Release, Producer, and all actors of the movie.
    
    Request Body : 
    No Body Required.
    
    Response : Sample Example :
    ```
    [
    {
        "movieId": 1,
        "movieName": "Venom ",
        "plot": "Marvel Movie",
        "releaseDate": "2021-08-18",
        "actors": [
            {
                "actorId": 7,
                "actorName": "King Ping",
                "bio": "Chinese actor",
                "dateOfBirth": "1991-03-07",
                "gender": "Male"
            }
        ],
        "producer": {
            "producerId": 6,
            "producerName": "Ashish Sharma ",
            "bio": "Indian Producer",
            "company": "Indian Studios",
            "dataOfBirth": "1998-05-11"
        }
    },
    {
        "movieId": 2,
        "movieName": "Matrix ",
        "plot": "Sci-Fi",
        "releaseDate": "1997-10-12",
        "actors": [
            {
                "actorId": 3,
                "actorName": "Keanu Reeves",
                "bio": "Canadian actor",
                "dateOfBirth": "1998-09-11",
                "gender": "Male"
            }
        ],
        "producer": {
            "producerId": 2,
            "producerName": "Wachowskis ",
            "bio": "Matrix Producer",
            "company": "Fox Studios",
            "dataOfBirth": "1977-11-04"
        }
    }
    ]
    ```
    
2. "/create-movie" : POST
    This API is used to create the movies by passing the details of movies like movie name , movie release date , plot and List of actors
    in movies also it can have details of Producer as well.
    
    Request Body :
    ```
     {
        "movieName": "The Batman ",
        "plot": "DC Movie",
        "releaseDate": "2021-08-18",
        "actors": [
            {
                "actorName": "Ben Afflick",
                "bio": "Chinese actor",
                "dateOfBirth": "1991-03-07",
                "gender": "Male"
            }
        ],
        "producer": {
            "producerName": "Walter Hamada",
            "bio": "Marvel Movoies Producer",
            "company": "Marvel Studios",
            "dataOfBirth": "1987-02-24"
        }
    }
    ```
    
    Response : It will return the movie details which have been save in DB.
    Sample Example :
    ```
      {
    "movieId": 7,
    "movieName": "The Batman ",
    "plot": "DC Movie",
    "releaseDate": "2021-08-18",
    "actors": [
        {
            "actorId": 10,
            "actorName": "Ben Afflick",
            "bio": "Chinese actor",
            "dateOfBirth": "1991-03-07",
            "gender": "Male"
        }
    ],
    "producer": {
        "producerId": 9,
        "producerName": "Walter Hamada ",
        "bio": "Marvel Movoies Producer",
        "company": "Marvel Studios",
        "dataOfBirth": "1987-02-24"
    }
}
```

3. "/movie/{id}" : PUT 
    This API is used to update the existing movie by passing the movieId. If movie with existing movieId found then
    it will update the movie and return the updated movie. If movieId is not found then will get 'Movie not found for this id :: " + movieId'.
    
    Request Body:
    We need to pass movie detail which needs to be update.
    ```
    {
        "movieName": "Monkey Man ",
        "plot": "Marvel Movie",
        "releaseDate": "2021-08-18",
        "actors": [
            {
                "actorName": "King Ping",
                "bio": "Chinese actor",
                "dateOfBirth": "1991-03-07",
                "gender": "Male"
            }
        ],
        "producer": {
            "producerName": "Ashish Sharma ",
            "bio": "Indian Producer",
            "company": "Indian Studios",
            "dataOfBirth": "1998-05-11"
        }
    }
    ```
 
 Response : It will return the updated movie details.
  Sample Example :
  ```
    {
    "movieId": 7,
    "movieName": "Monkey Man ",
    "plot": "Marvel Movie",
    "releaseDate": "2021-08-18",
    "actors": [
        {
            "actorId": 11,
            "actorName": "King Ping",
            "bio": "Chinese actor",
            "dateOfBirth": "1991-03-07",
            "gender": "Male"
        }
    ],
    "producer": {
        "producerId": 10,
        "producerName": "Ashish Sharma ",
        "bio": "Indian Producer",
        "company": "Indian Studios",
        "dataOfBirth": "1998-05-11"
    }
}
```

   
# UNIT TEST :
  The Unit Test has been written and code coverage is up to mark. For the Unit testing I have used JUNIT 5 and MOCKITO.
    
