package com.greglturnquist.inlined;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineAddresses", types = Person.class)
public interface InlineAddresses {

    String getFirstName();
    String getLastName();
    List<Address> getAddresses();

}
