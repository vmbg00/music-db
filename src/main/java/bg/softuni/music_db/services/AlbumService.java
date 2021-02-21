package bg.softuni.music_db.services;

import bg.softuni.music_db.models.entities.Album;
import bg.softuni.music_db.models.services.AlbumAddServiceModel;
import bg.softuni.music_db.models.views.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void add(AlbumAddServiceModel map);

    List<AlbumViewModel> getAlbums();

    void delete(Long id);

    int copiesSum();
}
