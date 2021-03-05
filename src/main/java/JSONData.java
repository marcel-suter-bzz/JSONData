import booklist.controller.ListController;
import twofiles.controller.TwoController;

public class JSONData {
    public static void main(String[] args) {
        JSONData program = new JSONData();
        program.testList();
    }

    private void testList() {
        /* Test with a list of books in Publisher */
        ListController listController = new ListController();
        listController.test();

        /* Test with two separate files */
        TwoController twoController = new TwoController();
        twoController.test();
    }
}
