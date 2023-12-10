package arraylist.methods.impl;

import arraylist.database.Database;
import arraylist.models.Book;

import java.security.interfaces.DSAKey;
import java.util.List;

public class BookService implements arraylist.methods.BookService {
    private Database database;

    public BookService(Database database) {
        this.database = database;
    }

    static long counter = 0;

    public static long id() {
        counter++;
        return counter;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        boolean isTrue = true;
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.libraries.get(i).getId() == libraryId) {
                database.libraries.get(i).setBooks(book);
                database.libraries.get(i).getBooks().get(database.libraries.get(i).getBooks().size() - 1).setId(id());
                System.out.println("Book with name " + book.getName() + " to library with id " + libraryId + " succesfully saved!");
                return book;
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Library with id " + libraryId + " not found!");
        }

        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        boolean isTrue = true;
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.libraries.get(i).getId() == libraryId) {
                if(database.libraries.get(i).getBooks() != null){
                    return database.libraries.get(i).getBooks();
                }else {
                    System.out.println("Library is not contains books!");
                }
            }else isTrue = false;
        }
        if (isTrue == false){
            System.out.println("Library with id " + libraryId + " not found!");
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        boolean isTrue = true;
        boolean isTrue2 = true;
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.libraries.get(i).getId() == libraryId) {
                isTrue = true;
                for (int j = 0; j < database.libraries.get(i).getBooks().size(); j++) {
                    if (database.libraries.get(i).getBooks().get(j).getId() == bookId) {
                        isTrue2 = true;
                        return database.libraries.get(i).getBooks().get(j);
                    }else isTrue2 = false;
                }
            }else isTrue = false;
        }
        if(isTrue == false){
            System.out.println("Library with id " + libraryId + " not found!");
        }
        if (isTrue2 == false){
            System.out.println("Book with id " + bookId + " not found!");
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.libraries.get(i).getId() == libraryId) {
                for (int j = 0; j < database.libraries.get(i).getBooks().size(); j++) {
                    if (database.libraries.get(i).getBooks().get(j).getId() == bookId) {
                        database.libraries.get(i).getBooks().remove(database.libraries.get(i).getBooks().get(j));
                        return "Book with id " + bookId + " succesfully deleted!";
                    }
                }
            }
        }
        return "Book with id " + bookId + " not found!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        boolean isTrue = true;
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.libraries.get(i).getId() == libraryId) {
                for (int j = 0; j < database.libraries.get(i).getBooks().size(); j++) {
                    database.libraries.get(i).getBooks().remove(database.libraries.get(i).getBooks().get(j));
                    System.out.println("Books in library with id " + libraryId + " succesfully cleared!");
                }
            } else isTrue = false;
        }
        if(isTrue == false){
            System.out.println("Library with id " + libraryId + " not found!");
        }
    }
}
