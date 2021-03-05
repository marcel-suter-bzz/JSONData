package twofiles.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Publisher {
    private String publisherUUID;
    private String publisher;
    @JsonIgnore
    private List<Book> bookList;

    public String getPublisherUUID() {
        return publisherUUID;
    }

    public void setPublisherUUID(String publisherUUID) {
        this.publisherUUID = publisherUUID;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
