package com.scaler.productservicedec2023.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "jt_user")
@Inheritance (strategy = InheritanceType.JOINED)
public class user {
    @Id
    private long id;
    private String name;
    private String email;
}
