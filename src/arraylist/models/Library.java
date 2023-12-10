package arraylist.models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private long id;
    private String name;
    private String address;
    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();

    public Library() {
    }

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books.add(books);
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Reader readers) {
        this.readers.add(readers);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                ", readers=" + readers +
                '}';
    }
}
