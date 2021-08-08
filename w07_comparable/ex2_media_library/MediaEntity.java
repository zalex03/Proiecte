package teme.w07_comparable.ex2_media_library;

class MediaEntity implements Comparable<MediaEntity> {
    private MediaType type;
    private String title;
    private int noOfDownloads;

    //TODO: add fields, rest of methods, make it Comparable etc..


    //Make the constructor protected (not public) to prevent construction of MediaEntity instances directly (only children are ok to be built)
    protected MediaEntity(MediaType type, String title, int noOfDownloads) {
        this.title = title;
        this.type = type;
        this.noOfDownloads = noOfDownloads;
    }

    public MediaEntity() {

    }


    public MediaType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getNoOfDownloads() {
        return noOfDownloads;
    }

    public void setNoOfDownloads(int noOfDownloads) {
        this.noOfDownloads = noOfDownloads;
    }

    @Override
    public String toString() {
        return "MediaEntity{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", noOfDownloads=" + noOfDownloads +
                '}';
    }

    @Override
    public int compareTo(MediaEntity o) {
        if (this.getNoOfDownloads() < (o.getNoOfDownloads())) {
            return -1;
        }

        if (this.getNoOfDownloads() == (o.getNoOfDownloads())) {

            return 0;
        }
        return 1;
    }
}
