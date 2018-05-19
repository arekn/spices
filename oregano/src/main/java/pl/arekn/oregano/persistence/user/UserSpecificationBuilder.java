package pl.arekn.oregano.persistence.user;

import org.springframework.data.jpa.domain.Specification;
import pl.arekn.oregano.persistence.SearchCriteria;
import pl.arekn.oregano.persistence.SpecificationBuilder;

import java.util.ArrayList;
import java.util.List;

public class UserSpecificationBuilder implements SpecificationBuilder<User> {

    private final List<SearchCriteria> params;

    public UserSpecificationBuilder() {
        this.params =  new ArrayList<>();
    }

    @Override
    public SpecificationBuilder with(SearchCriteria criteria) {
        this.params.add(criteria);
        return null;
    }

    @Override
    public Specification<User> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<User>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new UserSpecification(param));
        }

        Specification<User> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
