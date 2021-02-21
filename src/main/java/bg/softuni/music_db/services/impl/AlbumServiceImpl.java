package bg.softuni.music_db.services.impl;

import bg.softuni.music_db.models.entities.Album;
import bg.softuni.music_db.models.entities.Artist;
import bg.softuni.music_db.models.entities.User;
import bg.softuni.music_db.models.services.AlbumAddServiceModel;
import bg.softuni.music_db.models.views.AlbumViewModel;
import bg.softuni.music_db.repositories.AlbumRepository;
import bg.softuni.music_db.repositories.ArtistRepository;
import bg.softuni.music_db.repositories.UserRepository;
import bg.softuni.music_db.security.CurrentUser;
import bg.softuni.music_db.services.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository, UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AlbumAddServiceModel map) {
        Album album = new Album();
        Artist artist = this.artistRepository.findByName(map.getArtist());
        Optional<User> user = this.userRepository.findByUsername(currentUser.getName());

        album
                .setName(map.getAlbumName())
                .setArtist(artist)
                .setCopies(map.getCopies())
                .setDescription(map.getDescription())
                .setPrice(map.getPrice())
                .setImageUrl(map.getImageUrl())
                .setProducer(map.getProducer())
                .setReleaseDate(map.getReleaseDate())
                .setGenre(map.getGenre())
                .setUser(user.get())
                .setId(map.getId());

        this.albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> getAlbums() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        return this.albumRepository.findAllByOrderByCopiesDesc().stream().map(album -> {
            AlbumViewModel albumViewModel = this.modelMapper.map(album, AlbumViewModel.class);
            albumViewModel.setArtist(album.getArtist().getName().toString());
            albumViewModel.setReleaseDate(formatter.format(album.getReleaseDate()));

            return albumViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        this.albumRepository.deleteById(id);
    }

    @Override
    public int copiesSum() {
        try {
            return this.albumRepository.copiesSum();
        } catch (Exception e){
            return 0;
        }
    }
}
