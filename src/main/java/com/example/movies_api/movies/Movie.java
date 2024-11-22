package com.example.movies_api.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// Utilizamos a notação Documents para o spring saber que isso representa cada documento na coleção movies
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    //Vai fazer com que o banco de dados armazene apenas o ID das reviews e fazer com que as reviews fiquem guardadas
    // em uma collection diferente
    @DocumentReference
    private List<Review> reviewsIds;
}
