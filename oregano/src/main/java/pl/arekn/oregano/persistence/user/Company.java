package pl.arekn.oregano.persistence.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Company {
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_phrase")
    private String catchPhrase;
    @Column(name = "company_bs")
    private String bs;
}
