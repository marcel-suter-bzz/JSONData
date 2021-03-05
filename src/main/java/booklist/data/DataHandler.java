package booklist.data;

import booklist.model.Book;
import booklist.model.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {
    private static final DataHandler instance = new DataHandler();
    private static Map<String, Publisher> publisherMap;

    /**
     * default constructor: defeat instantiation
     */
    private DataHandler() {
        publisherMap = new HashMap<String, Publisher>();
    }

    /**
     * reads the publishers with their books
     */
    public static void readJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("./data.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Publisher[] publishers = objectMapper.readValue(jsonData, Publisher[].class);
            for (Publisher publisher : publishers) {
                getPublisherMap().put(publisher.getPublisherUUID(), publisher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * write the publishers with their books
     *
     */
    public static void writeJSON(List<Publisher> publisherList) {
        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer;
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("./data.json");
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectMapper.writeValue(writer, publisherList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * creates a map of books by iterating through the publishers
     * @return
     */
    public static Map<String, Book> getBookMap() {
        Map<String, Book> bookMap = new HashMap<String, Book>();
        for (Map.Entry<String, Publisher> entry : getPublisherMap().entrySet()) {
            Publisher publisher = entry.getValue();
            for (Book book : publisher.getBookList()) {
                bookMap.put(book.getBookUUID(), book);
            }
        }
        return bookMap;
    }

    public static Publisher findPublisherByBook(String bookUUID) {
        Publisher publisher = null;
        for (Map.Entry<String, Publisher> entry : getPublisherMap().entrySet()) {
            publisher = entry.getValue();
            for (Book book : publisher.getBookList()) {
                if (book.getBookUUID() == bookUUID)
                    return publisher;
            }
        }
        return null;
    }

    public static Map<String, Publisher> getPublisherMap() {
        if (publisherMap.isEmpty())
            readJSON();
        return publisherMap;
    }

    public static void setPublisherMap(Map<String, Publisher> publisherMap) {
        DataHandler.publisherMap = publisherMap;
    }
}
