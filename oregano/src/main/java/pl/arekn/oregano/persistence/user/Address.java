package pl.arekn.oregano.persistence.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Coordinates geo;
}
