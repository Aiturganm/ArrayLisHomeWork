package arraylist;

import arraylist.database.Database;
import arraylist.methods.BookService;
import arraylist.methods.impl.LibraryService;
import arraylist.methods.impl.ReaderService;
import arraylist.models.Book;
import arraylist.models.Library;
import arraylist.models.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        LibraryService libraryService  = new LibraryService(database);
        BookService bookService = new arraylist.methods.impl.BookService(database);
        ReaderService readerService = new ReaderService(database);

        List<Library> libraryList = new ArrayList<>();
        libraryList.add(new Library("National Library", "Chui 123"));
        libraryList.add(new Library("K. Bayalinov", "Yunusalieva 19"));
        libraryList.add(new Library("A. Osmonov", "Jibek jolu 12"));

        while(true){
            System.out.println("""
                    \n
                    1. Save library
                    2. Get all libraries
                    3. Get library by id
                    4. Update library
                    5. Delete library
                    6. Save book
                    7. Get all books
                    8. Get book by id
                    9. Delete book
                    10. Clear books  by library's id
                    11. Save reader
                    12. Get all readers
                    13. Get reader by id
                    14. Update reader
                    15. Assign reader to library
                    """);
            switch (scanner.nextLine().toLowerCase()){
                case "1" -> {
                    libraryService.saveLibrary(libraryList);
                    System.out.println("Succesfully saved libraries: ");
                    for (int i = 0; i < libraryList.size(); i++) {
                        System.out.println(libraryList.get(i));
                    }
                }
                case "2" -> {
                    System.out.println("All libraries: ");
                    for (int i = 0; i < libraryService.getAllLibraries().size(); i++) {
                        System.out.println(libraryService.getAllLibraries().get(i));
                    }
                }
                case "3" -> {
                    System.out.println("Enter the id of library: ");
                    System.out.println(libraryService.getLibraryById(new Scanner(System.in).nextLong()));
                }
                case "4" -> {
                    System.out.println("Enter the id of library: ");
                    long id = new Scanner(System.in).nextLong();
                    Library library = new Library();
                    System.out.println("Enter name of library: ");
                    library.setName(new Scanner(System.in).nextLine());
                    System.out.println("Enter address of library: ");
                    library.setAddress(new Scanner(System.in).nextLine());
                    System.out.println(libraryService.updateLibrary(id, library));
                }
                case "5" -> {
                    System.out.println("Enter the id of library: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(libraryService.deleteLibrary(id));
                }
                case "6" -> {
                    System.out.println("Enter library's id: ");
                    long id = new Scanner(System.in).nextLong();
                    Book book = new Book();
                    System.out.println("Enter book name: ");
                    book.setName(scanner.nextLine());
                    System.out.println("Enter book's author: ");
                    book.setAuthor(scanner.nextLine());
                    System.out.println(bookService.saveBook(id, book));
                }
                case "7" -> {
                    System.out.println("Enter library's id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(bookService.getAllBooks(id));
                }
                case "8" -> {
                    System.out.println("Enter library's id: ");
                    Long libId = new Scanner(System.in).nextLong();
                    System.out.println("Enter book's id: ");
                    Long bookId = new Scanner(System.in).nextLong();
                    System.out.println(bookService.getBookById(libId, bookId));
                }
                case "9" -> {
                    System.out.println("Enter library's id: ");
                    Long libId = new Scanner(System.in).nextLong();
                    System.out.println("Enter book's id: ");
                    Long bookId = new Scanner(System.in).nextLong();
                    System.out.println(bookService.deleteBook(libId, bookId));
                }
                case "10" -> {
                    System.out.println("Enter library's id: ");
                    Long id = new Scanner(System.in).nextLong();
                    bookService.clearBooksByLibraryId(id);
                }
                case "11" -> {
                    Reader reader = new Reader();
                    System.out.println("Enter reader's full name: ");
                    reader.setFullName(scanner.nextLine());
                    System.out.println("Enter reader's email: ");
                    reader.setEmail(scanner.nextLine());
                    System.out.println("Enter reader's fhone number: ");
                    reader.setPhoneNumber(scanner.nextLine());
                    System.out.println("Enter reader's gender: ");
                    reader.setGender(scanner.nextLine());
                    readerService.saveReader(reader);
                }
                case "12" -> {
                    System.out.println(readerService.getAllReaders());
                }
                case "13" -> {
                    System.out.println("Enter reader's id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(readerService.getReaderById(id));
                }
                case "14" -> {
                    System.out.println();
                    System.out.println("Enter reader's id: ");
                    Long id = new Scanner(System.in).nextLong();
                    Reader reader = new Reader();
                    System.out.println("Enter reader's full name: ");
                    reader.setFullName(scanner.nextLine());
                    System.out.println("Enter reader's email: ");
                    reader.setEmail(scanner.nextLine());
                    System.out.println("Enter reader's fhone number: ");
                    reader.setPhoneNumber(scanner.nextLine());
                    System.out.println("Enter reader's gender: ");
                    reader.setGender(scanner.nextLine());
                    System.out.println(readerService.updateReader(id, reader));
                }
                case "15" -> {
                    System.out.println("Enter reader's id: ");
                    Long readerId = new Scanner(System.in).nextLong();
                    System.out.println("Enter library's id: ");
                    Long libraryId = new Scanner(System.in).nextLong();
                    readerService.assignReaderToLibrary(readerId, libraryId);
                }
            }
        }
    }
}
