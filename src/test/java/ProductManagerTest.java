import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Book book1 = new Book(1, "book1", 555, "author1");
    Smartphone smartphone1 = new Smartphone(2, "smartphone1", 17777, "manufacturer1");
    Book book2 = new Book(3, "book2", 484, "author2");
    Smartphone smartphone2 = new Smartphone(4, "smartphone2", 20226, "manufacturer2");

    Repository repo = new Repository();

    @Test
    public void shouldFindProduct() {
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        manager.searchBy("book");

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindProduct() {
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        manager.searchBy("laptop");

        Product[] expected = {};
        Product[] actual = manager.searchBy("laptop");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductByIncompleteWord() {
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        manager.searchBy("phone");

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("phone");

        Assertions.assertArrayEquals(expected, actual);
    }
}
