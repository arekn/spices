package pl.arekn.oregano.persistence.album;

import org.springframework.data.jpa.domain.Specification;
import pl.arekn.oregano.persistence.SearchCriteria;
import pl.arekn.oregano.persistence.SpecificationBuilder;

import java.util.ArrayList;
import java.util.List;

public class AlbumSpecificationBuilder implements SpecificationBuilder<Album> {

    private final List<SearchCriteria> params;

    public AlbumSpecificationBuilder() {
        this.params =  new ArrayList<>();
    }

    @Override
    public SpecificationBuilder with(SearchCriteria criteria) {
        this.params.add(criteria);
        return null;
    }

    @Override
    public Specification<Album> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Album>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new AlbumSpecification(param));
        }

        Specification<Album> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
