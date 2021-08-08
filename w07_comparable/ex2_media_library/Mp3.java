package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

class Mp3 extends MediaEntity {

    private String title;
    private String singer;
    private String album;
    private int noOfDownloads;

    Mp3(String title, String singer, String album, int noOfDownloads) {
        super(MediaType.MP3, title, noOfDownloads);
        this.title = title;
        this.singer = singer;
        this.album = album;
        this.noOfDownloads = noOfDownloads;
    }


    @Override
    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public int getNoOfDownloads() {
        return noOfDownloads;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mp3 mp3 = (Mp3) o;
        return noOfDownloads == mp3.noOfDownloads &&
                Objects.equals(title, mp3.title) &&
                Objects.equals(singer, mp3.singer) &&
                Objects.equals(album, mp3.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, singer, album, noOfDownloads);
    }
}
