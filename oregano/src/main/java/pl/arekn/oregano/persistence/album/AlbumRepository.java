package pl.arekn.oregano.persistence.album;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "albums", path = "album")
public interface AlbumRepository extends CrudRepository<Album, Long>, JpaSpecificationExecutor<Album> {
}
