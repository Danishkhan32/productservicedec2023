package com.scaler.productservicedec2023.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "ms_mentor")
public class mentor  extends user {
    @Id
    private Long id;
    private double averageRating;
}