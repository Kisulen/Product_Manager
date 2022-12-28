import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Book book1 = new Book(1, "book1", 555, "author1");
    Smartphone smartphone1 = new Smartphone(2, "smartphone1", 17777, "manufacturer1");
    Book book2 = new Book(3, "book2", 484, "author2");
    Smartphone smartphone2 = new Smartphone(4, "smartphone2", 20226, "manufacturer2");

    @Test
    public void shouldAddProducts() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNoProducts() {
        Repository repo = new Repository();

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneProduct() {
        Repository repo = new Repository();
        repo.save(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.removeByID(4);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenRemovingByInvalidID() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeByID(17);
        });


    }

    @Test
    public void shouldRemoveAll() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.removeByID(4);
        repo.removeByID(3);
        repo.removeByID(2);
        repo.removeByID(1);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdProduct() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.findById(3);

        Product expected = book2;
        Product actual = repo.findById(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNull() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.findById(7);

        Product expected = null;
        Product actual = repo.findById(7);

        Assertions.assertEquals(expected, actual);
    }


}

