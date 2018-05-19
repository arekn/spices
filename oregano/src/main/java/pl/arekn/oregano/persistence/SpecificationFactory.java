package pl.arekn.oregano.persistence;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SpecificationFactory {

    private static final int KEY = 1;
    private static final int OPERATION = 2;
    private static final int VALUE = 3;

    public <E> Specification<E> getSpecification(String searchQuery, SpecificationBuilder<E> builder) {
        Pattern pattern = Pattern.compile("([\\w.]+)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(searchQuery + ",");
        while (matcher.find()) {
            builder.with(new SearchCriteria(matcher.group(KEY), matcher.group(OPERATION), matcher.group(VALUE)));
        }
        return builder.build();
    }
}
