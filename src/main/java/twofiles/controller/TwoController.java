package twofiles.controller;

import twofiles.data.DataHandler;
import twofiles.model.Book;
import twofiles.model.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoController {
    List<Publisher> publishers = new ArrayList<Publisher>();
    List<Book> books = new ArrayList<Book>();
    /**
     * runs the test with a book-List in Publisher
     */
    public void test() {
        generateData();
        DataHandler.writePublishers(publishers);
        DataHandler.writeBooks(books);

        Map<String, Publisher> publisherMap = DataHandler.getPublisherMap();
        Map<String, Book> bookMap = DataHandler.getBookMap();
    }
    public void generateData() {
        Publisher publisher;
        Book book;

        publisher = new Publisher();
        publishers.add(publisher);
        publisher.setBookList( new ArrayList<Book>() );
        publisher.setPublisherUUID("ecd86148-5341-43c6-81ed-f3f4595965dc");
        publisher.setPublisher("Orbit");

        book = new Book();
        books.add(book);
        publisher.getBookList().add(book);
        book.setBookUUID("3247c340-c712-402e-b400-0a23a9368c97");
        book.setTitle("An Echo Of Things To Come");

        book = new Book();
        books.add(book);
        publisher.getBookList().add(book);
        book.setBookUUID("db117daa-e295-4597-abcd-a69496797dc0");
        book.setTitle("The shadow of what was lost");

        publisher = new Publisher();
        publishers.add(publisher);
        publisher.setBookList( new ArrayList<Book>() );
        publisher.setPublisherUUID("606cc4a5-8bfd-4e24-85c1-ecf6b9814712");
        publisher.setPublisher("Bantam");

        book = new Book();
        books.add(book);
        publisher.getBookList().add(book);
        book.setBookUUID("c746a291-0ef9-4b2a-8268-392b12d636bd");
        book.setTitle("The Winds of Winter");

    }
}
