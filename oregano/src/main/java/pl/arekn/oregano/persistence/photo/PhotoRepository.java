package pl.arekn.oregano.persistence.photo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "photos", path = "photo")
public interface PhotoRepository extends CrudRepository<Photo, Long>, JpaSpecificationExecutor<Photo> {
}
