package bg.softuni.music_db.models.views;

import java.math.BigDecimal;

public class AlbumViewModel {
    private Long id;
    private String name;
    private String artist;
    private String genre;
    private BigDecimal price;
    private String releaseDate;
    private String imageUrl;
    private int copies;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public AlbumViewModel setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(int copies) {
        this.copies = copies;
        return this;
    }
}
