package pl.arekn.oregano.persistence;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<E> {

    SpecificationBuilder with(SearchCriteria criteria);

    Specification<E> build();
}
