package com.scaler.productservicedec2023.inheritancedemo.mappedsuperclass;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class user {
    private String name;
    private String email;
}
