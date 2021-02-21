package bg.softuni.music_db.models.entities;

import bg.softuni.music_db.models.entities.enums.ArtistName;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    private ArtistName name;
    private String careerInformation;

    public Artist() {
    }

    @Enumerated(value = EnumType.STRING)
    public ArtistName getName() {
        return name;
    }

    public Artist setName(ArtistName name) {
        this.name = name;
        return this;
    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
