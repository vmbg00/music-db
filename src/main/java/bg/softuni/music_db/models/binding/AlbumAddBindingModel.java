package bg.softuni.music_db.models.binding;

import bg.softuni.music_db.models.entities.enums.ArtistName;
import bg.softuni.music_db.models.entities.enums.Genre;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class AlbumAddBindingModel {

    private String albumName;
    private String imageUrl;
    private BigDecimal price;
    private int copies;
    private Date releaseDate;
    private String producer;
    private ArtistName artist;
    private Genre genre;
    private String description;

    public AlbumAddBindingModel() {
    }

    @NotBlank(message = "Cannot be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    public String getAlbumName() {
        return albumName;
    }

    public AlbumAddBindingModel setAlbumName(String albumName) {
        this.albumName = albumName;
        return this;
    }

    @NotBlank(message = "Cannot be blank")
    @Size(min = 5, message = "Image url must be more than 5 characters")
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @NotNull(message = "Price required")
    @DecimalMin(value = "0", message = "Price must be positive")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Positive(message = "Copies must be positive")
    public int getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Date cannot be in the future")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public AlbumAddBindingModel setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull(message = "You must select an artist")
    public ArtistName getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistName artist) {
        this.artist = artist;
        return this;
    }

    @NotNull(message = "You must select a genre")
    public Genre getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @NotBlank(message = "")
    @Size(min = 5, message = "Description length must be more than 5 characters")
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
