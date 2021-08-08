package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

class Video extends MediaEntity {

    private String title;
    private int duration;
    private boolean fullHD;
    private int noOfDownloads;

    Video(String title, int duration, boolean fullHD, int noOfDownloads) {
        super(MediaType.VIDEO, title, noOfDownloads);
        this.title = title;
        this.duration = duration;
        this.fullHD = fullHD;
        this.noOfDownloads = noOfDownloads;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isFullHD() {
        return fullHD;
    }

    @Override
    public int getNoOfDownloads() {
        return noOfDownloads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return duration == video.duration &&
                fullHD == video.fullHD &&
                noOfDownloads == video.noOfDownloads &&
                Objects.equals(title, video.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration, fullHD, noOfDownloads);
    }
}
