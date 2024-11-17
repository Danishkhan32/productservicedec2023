package com.scaler.productservicedec2023.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "tpc_mentor")
public class mentor  extends user {
    private double averageRating;
}
