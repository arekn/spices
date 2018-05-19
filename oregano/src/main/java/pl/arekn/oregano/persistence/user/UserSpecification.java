package pl.arekn.oregano.persistence.user;

import org.springframework.data.jpa.domain.Specification;
import pl.arekn.oregano.persistence.PredicateSolver;
import pl.arekn.oregano.persistence.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

class UserSpecification implements Specification<User> {

    private final PredicateSolver predicateSolver;

    UserSpecification(SearchCriteria criteria) {
        this.predicateSolver = new PredicateSolver(criteria);
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return predicateSolver.solvePredicate(root, criteriaBuilder);
    }

}

