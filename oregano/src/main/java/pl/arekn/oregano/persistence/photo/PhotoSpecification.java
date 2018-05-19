package pl.arekn.oregano.persistence.photo;

import org.springframework.data.jpa.domain.Specification;
import pl.arekn.oregano.persistence.PredicateSolver;
import pl.arekn.oregano.persistence.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

class PhotoSpecification implements Specification<Photo> {

    private final PredicateSolver predicateSolver;

    PhotoSpecification(SearchCriteria criteria) {
        this.predicateSolver = new PredicateSolver(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Photo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return predicateSolver.solvePredicate(root, criteriaBuilder);
    }
}

