package pl.arekn.oregano.persistence.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class Coordinates {
    @Column(name = "coordinates_lat")
    private Double lat;
    @Column(name = "coordinates_lng")
    private Double lng;
}