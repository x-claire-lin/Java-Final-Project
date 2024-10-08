package dataaccesslayer;

import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cheng
 */
public class AuthorsDaoImpl {

    public AuthorsDaoImpl() {
    }

    public List<Author> getAllAuthors() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Author> authors = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT authorID, firstName, lastName FROM authors ORDER BY authorID");
            rs = pstmt.executeQuery();
            authors = new ArrayList<Author>();
            while (rs.next()) {
                Author author = new Author();
                author.setAuthorID(new Integer(rs.getInt("authorID")));
                author.setFirstName(rs.getString("firstName"));
                author.setLastName(rs.getString("lastName"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return authors;
    }

    public void addAuthor(Author author) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO authors (firstName, lastName) VALUES(?, ?)");
            pstmt.setString(1, author.getFirstName());
            pstmt.setString(2, author.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
