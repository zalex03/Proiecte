package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

class Book extends MediaEntity {

    private String title;
    private String author;
    private String publisher;
    private int noOfDownloads;

    Book(String title, String author, String publisher, int noOfDownloads) {
        //TODO
        super(MediaType.BOOK, title, noOfDownloads);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.noOfDownloads = noOfDownloads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return noOfDownloads == book.noOfDownloads &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher, noOfDownloads);
    }


}
