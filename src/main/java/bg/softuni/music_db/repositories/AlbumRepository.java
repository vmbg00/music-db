package bg.softuni.music_db.repositories;

import bg.softuni.music_db.models.entities.Album;
import bg.softuni.music_db.models.views.AlbumViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT SUM(a.copies) FROM Album as a")
    int copiesSum();

    List<Album> findAllByOrderByCopiesDesc();
}
