package com.hydracommunications.meter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private UUID id;
    private String name;
    public List<Integer> ratings = new ArrayList<>(0);

    public Restaurant(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getAverageRating() {
        double sum = 0;

        if (ratings.isEmpty()) {
            return 0.0;
        } else {
            for (Integer rating : ratings) {
                sum += rating;
            }

            return sum / ratings.size();
        }
    }

    public void addRating(Integer rating) {
        ratings.add(rating);
    }
}
