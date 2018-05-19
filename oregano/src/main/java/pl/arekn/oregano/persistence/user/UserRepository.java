package pl.arekn.oregano.persistence.user;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "user")
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
}
