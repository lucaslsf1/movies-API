package com.example.movies_api.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // Utilizando o mongo template para uma query um pouco mais personalizada
    @Autowired
    private MongoTemplate mongoTemplate;

    // Tentando achar o filme com o imdbId e se achar compatível criar um novo review e associar com o filme achado.
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Dando update no documento Movie ONDE o criterio imdbId é compatível com o imdbId que chegou.
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
