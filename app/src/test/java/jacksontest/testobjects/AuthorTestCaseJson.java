package jacksontest.testobjects;

import java.util.List;

public class AuthorTestCaseJson {
    
    private String authorName;
    private List<BookTestCaseJson> books;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<BookTestCaseJson> getBooks() {
        return books;
    }
    
    public void setBooks(List<BookTestCaseJson> books) {
        this.books = books;
    }

}
