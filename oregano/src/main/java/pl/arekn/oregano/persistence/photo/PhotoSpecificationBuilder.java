package pl.arekn.oregano.persistence.photo;

import org.springframework.data.jpa.domain.Specification;
import pl.arekn.oregano.persistence.SearchCriteria;
import pl.arekn.oregano.persistence.SpecificationBuilder;

import java.util.ArrayList;
import java.util.List;

public class PhotoSpecificationBuilder implements SpecificationBuilder<Photo> {

    private final List<SearchCriteria> params;

    public PhotoSpecificationBuilder() {
        this.params =  new ArrayList<>();
    }

    @Override
    public SpecificationBuilder with(SearchCriteria criteria) {
        this.params.add(criteria);
        return null;
    }

    @Override
    public Specification<Photo> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Photo>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new PhotoSpecification(param));
        }

        Specification<Photo> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
