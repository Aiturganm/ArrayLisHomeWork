package arraylist.database;

import arraylist.models.Book;
import arraylist.models.Library;
import arraylist.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Library> libraries;
    public List<Book> books;
    public List<Reader> readers = new ArrayList<>();
}
