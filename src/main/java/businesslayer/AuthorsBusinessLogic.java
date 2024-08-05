
package businesslayer;

import dataaccesslayer.AuthorsDaoImpl;
import model.Author;

import java.sql.SQLException;
import java.util.List;

public class AuthorsBusinessLogic {

    private AuthorsDaoImpl authorsDao = null;

    public AuthorsBusinessLogic() {

        authorsDao = new AuthorsDaoImpl();
    }

    public List<Author> getAllAuthors() throws SQLException {
        return authorsDao.getAllAuthors();
    }

    public void addAuthor(Author author) {
        authorsDao.addAuthor(author);
    }
}
