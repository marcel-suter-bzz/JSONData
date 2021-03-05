package twofiles.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import twofiles.model.Book;
import twofiles.model.Publisher;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {
    static Map<String, Publisher> publisherMap = null;
    static Map<String, Book> bookMap = null;

    public static void writePublishers(List<Publisher> publisherList) {
        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer;
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("./publishers.json");  // FIXME use path from config
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectMapper.writeValue(writer, publisherList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeBooks(List<Book> bookList) {
        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer;
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("./books.json");  // FIXME use path from config
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectMapper.writeValue(writer, bookList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void readBooks() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("./books.json")); // FIXME use path from config
            ObjectMapper objectMapper = new ObjectMapper();
            Book[] books = objectMapper.readValue(jsonData, Book[].class);
            for (Book book : books) {
                getBookMap().put(book.getBookUUID(), book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readPublishers() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("./publishers.json")); // FIXME use path from config
            ObjectMapper objectMapper = new ObjectMapper();
            Publisher[] publishers = objectMapper.readValue(jsonData, Publisher[].class);
            for (Publisher publisher : publishers) {
                getPublisherMap().put(publisher.getPublisherUUID(), publisher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Publisher> getPublisherMap() {
        if (publisherMap == null) {
            publisherMap = new HashMap<String, Publisher>();
            readPublishers();
        }
        return publisherMap;
    }

    public static void setPublisherMap(Map<String, Publisher> publisherMap) {
        publisherMap = publisherMap;
    }

    public static Map<String, Book> getBookMap() {
        if (bookMap == null) {
            bookMap = new HashMap<String, Book>();
            readBooks();
        }
        return bookMap;
    }

    public static void setBookMap(Map<String, Book> bookMap) {
        bookMap = bookMap;
    }
}
