package pl.arekn.oregano.persistence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class PredicateSolver {


    private final SearchCriteria criteria;

    public PredicateSolver(SearchCriteria criteria) {
        this.criteria =criteria;
    }

    public Predicate solvePredicate(Root<?> root, CriteriaBuilder criteriaBuilder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    getNestedPath(root), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    getNestedPath(root), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (getNestedPath(root).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        getNestedPath(root), "%" + criteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }

    private Path getNestedPath(Root root) {
        if (!criteria.getKey().contains(".")) {
            return root.get(criteria.getKey());
        } else {
            List<String> split = Arrays.asList(criteria.getKey().split("\\."));
            Iterator<String> iterator = split.iterator();
            Path result = root.get(iterator.next());
            while (iterator.hasNext()) {
                result = result.get(iterator.next());
            }
            return result;
        }
    }
}
