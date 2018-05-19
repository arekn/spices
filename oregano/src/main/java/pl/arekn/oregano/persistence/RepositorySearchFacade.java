package pl.arekn.oregano.persistence;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.arekn.oregano.persistence.album.Album;
import pl.arekn.oregano.persistence.album.AlbumRepository;
import pl.arekn.oregano.persistence.photo.Photo;
import pl.arekn.oregano.persistence.photo.PhotoRepository;
import pl.arekn.oregano.persistence.user.User;
import pl.arekn.oregano.persistence.user.UserRepository;

import java.util.List;

@Service
public class RepositorySearchFacade {

    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;
    private final AlbumRepository albumRepository;

    public RepositorySearchFacade(UserRepository userRepository, PhotoRepository photoRepository, AlbumRepository albumRepository) {
        this.userRepository = userRepository;
        this.photoRepository = photoRepository;
        this.albumRepository = albumRepository;
    }

    public List<User> findUsers(Specification<User> specification){
        return userRepository.findAll(specification);
    }

    public List<Album> findAlbums(Specification<Album> specification){
        return albumRepository.findAll(specification);
    }

    public List<Photo> findPhotos(Specification<Photo> specification){
        return photoRepository.findAll(specification);
    }
}
