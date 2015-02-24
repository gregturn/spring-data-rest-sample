package com.greglturnquist.inlined;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = InlineAddresses.class)
public interface PersonRepository extends CrudRepository<Person, Long> {
}
