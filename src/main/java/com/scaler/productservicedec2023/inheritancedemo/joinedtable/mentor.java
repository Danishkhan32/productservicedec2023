package com.scaler.productservicedec2023.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "jt_mentor")
@PrimaryKeyJoinColumn(name ="user_id")
public class mentor  extends user{
    private double averageRating;
}
