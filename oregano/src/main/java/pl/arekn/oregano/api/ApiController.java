package pl.arekn.oregano.api;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.arekn.oregano.persistence.RepositorySearchFacade;
import pl.arekn.oregano.persistence.SpecificationFactory;
import pl.arekn.oregano.persistence.album.Album;
import pl.arekn.oregano.persistence.album.AlbumSpecificationBuilder;
import pl.arekn.oregano.persistence.photo.Photo;
import pl.arekn.oregano.persistence.photo.PhotoSpecificationBuilder;
import pl.arekn.oregano.persistence.user.User;
import pl.arekn.oregano.persistence.user.UserSpecificationBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final RepositorySearchFacade repositorySearch;
    private final SpecificationFactory specificationFactory;

    public ApiController(RepositorySearchFacade repositorySearch, SpecificationFactory specificationFactory) {
        this.repositorySearch = repositorySearch;
        this.specificationFactory = specificationFactory;
    }

    @GetMapping(value = "/user")
    public List<User> searchUsers(@RequestParam(value = "search") String searchQuery) {
        UserSpecificationBuilder builder = new UserSpecificationBuilder();
        Specification<User> spec = specificationFactory.getSpecification(searchQuery, builder);
        return repositorySearch.findUsers(spec);
    }

    @GetMapping(value = "/photo")
    public List<Photo> searchPhotos(@RequestParam(value = "search") String searchQuery) {
        PhotoSpecificationBuilder builder = new PhotoSpecificationBuilder();
        Specification<Photo> spec = specificationFactory.getSpecification(searchQuery, builder);
        return repositorySearch.findPhotos(spec);
    }

    @GetMapping(value = "/album")
    public List<Album> searchAlbums(@RequestParam(value = "search") String searchQuery) {
        AlbumSpecificationBuilder builder = new AlbumSpecificationBuilder();
        Specification<Album> spec = specificationFactory.getSpecification(searchQuery, builder);
        return repositorySearch.findAlbums(spec);
    }

}
