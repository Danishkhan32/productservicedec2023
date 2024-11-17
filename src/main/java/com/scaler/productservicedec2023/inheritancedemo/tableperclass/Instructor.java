package com.scaler.productservicedec2023.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity( name = "tpc_instructor")
public class Instructor extends user {
    private String favouriteStudent;

}
