package com.greglturnquist.inlined;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public DatabaseLoader(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @PostConstruct
    private void init() {

        List<Address> addresses = StreamSupport.stream(addressRepository.save(Arrays.asList(new Address[]{
                new Address("Bag End", "The Shire", "Middle Earth"),
                new Address("The Undying Lands", "Ships", "Elven Lands")
        })).spliterator(), false).collect(Collectors.toList());

        personRepository.save(new Person(
                "Frodo",
                "Baggins",
                addresses));
    }
}
