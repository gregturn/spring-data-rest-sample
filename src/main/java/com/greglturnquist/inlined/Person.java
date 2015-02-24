package com.greglturnquist.inlined;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor()
public class Person {

    private @Id @GeneratedValue Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull @OneToMany List<Address> addresses;

}
