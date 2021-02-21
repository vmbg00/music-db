package bg.softuni.music_db.models.services;

import bg.softuni.music_db.models.entities.enums.ArtistName;
import bg.softuni.music_db.models.entities.enums.Genre;

import java.math.BigDecimal;
import java.util.Date;

public class AlbumAddServiceModel {

    private Long id;
    private String albumName;
    private String imageUrl;
    private BigDecimal price;
    private int copies;
    private Date releaseDate;
    private String producer;
    private ArtistName artist;
    private Genre genre;
    private String description;

    public AlbumAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAlbumName() {
        return albumName;
    }

    public AlbumAddServiceModel setAlbumName(String albumName) {
        this.albumName = albumName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public AlbumAddServiceModel setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public AlbumAddServiceModel setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddServiceModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public ArtistName getArtist() {
        return artist;
    }

    public AlbumAddServiceModel setArtist(ArtistName artist) {
        this.artist = artist;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumAddServiceModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
