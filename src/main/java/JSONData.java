import booklist.controller.BookController;

public class JSONData {
    public static void main(String[] args) {
        JSONData program = new JSONData();
        program.testList();
    }

    private void testList() {
        BookController bookController = new BookController();
        bookController.test();
    }
}
