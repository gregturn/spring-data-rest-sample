package com.greglturnquist.springdatarestexample

@Grab('spring-boot-starter-data-rest')
@Grab('spring-boot-starter-data-jpa')
@Grab('h2')
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.config.Projection
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Person {
	@Id @GeneratedValue
	Long id

	String firstName
	String lastName

	@OneToOne
	Address address
}

@Entity
class Address {
	@Id @GeneratedValue
	Long id

	String street
	String state
	String country
}

//@Projection(name = "noAddresses", types = [Person])
interface NoAddresses {
	String getFirstName()
	String getLastName()
}

//@Projection(name = 'inlineAddress', types = [Person])
interface InlineAddress {
	String getFirstName()
	String getLastName()
	Address getAddress()
}

//@RepositoryRestResource(excerptProjection = InlineAddress)
interface PersonRepository extends CrudRepository<Person, Long> {}

interface AddressRepository extends CrudRepository<Address, Long> {}

@Component
class DataLoader {

	PersonRepository personRepository
	AddressRepository addressRepository

	@Autowired
	public DataLoader(PersonRepository personRepository, AddressRepository addressRepository) {
		this.personRepository = personRepository
		this.addressRepository = addressRepository
	}

	@PostConstruct
	void init() {
		personRepository.save(new Person(
			firstName: "Frodo", 
			lastName: "Baggins", 
			address: addressRepository.save(new Address(
				street: "Bag End", 
				state: "The Shire", 
				country: "Middle Earth"))))
	}

}
