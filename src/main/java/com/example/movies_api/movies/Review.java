package com.example.movies_api.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Dúvidas referentes as anotações conferir a classe Movie, pois são usadas as mesmas.
@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;

    // Utilizando um construtor que só necessite do body para a criação, pois o id é gerado automaticamente nesse caso
    public Review(String body) {
        this.body = body;
    }
}
