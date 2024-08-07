package businesslayer;

import dataaccesslayer.AuthorsDaoImpl;
import model.Author;

import java.sql.SQLException;
import java.util.List;

/**
 * This class contains business logic related to authors.
 * It interacts with the data access layer to perform operations
 * related to authors, such as retrieving all authors and adding a new author.
 */
public class AuthorsBusinessLogic {

    // Instance of AuthorsDaoImpl to interact with the database
    private AuthorsDaoImpl authorsDao = null;

    /**
     * Constructor that initializes the AuthorsDaoImpl instance.
     */
    public AuthorsBusinessLogic() {
        authorsDao = new AuthorsDaoImpl();
    }

    /**
     * Retrieves a list of all authors from the database.
     *
     * @return List<Author> - A list of Author objects representing all authors.
     * @throws SQLException - If there is an error accessing the database.
     */
    public List<Author> getAllAuthors() throws SQLException {
        return authorsDao.getAllAuthors();
    }

    /**
     * Adds a new author to the database.
     *
     * @param author - The Author object containing details of the author to be added.
     */
    public void addAuthor(Author author) {
        authorsDao.addAuthor(author);
    }
}
