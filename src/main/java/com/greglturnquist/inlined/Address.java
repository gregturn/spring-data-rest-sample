package com.greglturnquist.inlined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {

    private @Id @GeneratedValue Long id;
    private @NonNull String street;
    private @NonNull String state;
    private @NonNull String country;

}
