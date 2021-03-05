package booklist.model;

import booklist.data.DataHandler;

public class Book {
    private String bookUUID;
    private String title;

    /**
     * special getter for publisher
     * @return
     */
    public Publisher getPublisher() {
        return DataHandler.findPublisherByBook(getBookUUID());
    }
    public String getBookUUID() {
        return bookUUID;
    }

    public void setBookUUID(String bookUUID) {
        this.bookUUID = bookUUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
