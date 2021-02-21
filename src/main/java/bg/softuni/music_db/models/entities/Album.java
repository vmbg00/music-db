package bg.softuni.music_db.models.entities;

import bg.softuni.music_db.models.entities.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity{

    private String name;
    private String imageUrl;
    private String description;
    private Genre genre;
    private int copies;
    private BigDecimal price;
    private Date releaseDate;
    private String producer;
    private Artist artist;
    private User user;

    public Album() {
    }

    public Genre getGenre() {
        return genre;
    }

    public Album setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @Column
    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    public int getCopies() {
        return copies;
    }

    public Album setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "release_date", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public Album setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Column
    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @ManyToOne
    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Album setUser(User user) {
        this.user = user;
        return this;
    }
}
