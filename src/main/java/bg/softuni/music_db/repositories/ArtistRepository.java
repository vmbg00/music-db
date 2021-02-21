package bg.softuni.music_db.repositories;

import bg.softuni.music_db.models.entities.Artist;
import bg.softuni.music_db.models.entities.enums.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(ArtistName artist);
}
