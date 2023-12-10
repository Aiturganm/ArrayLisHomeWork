package arraylist.methods.impl;

import arraylist.database.Database;
import arraylist.models.Library;

import java.util.List;

public class LibraryService implements arraylist.methods.LibraryService {
    private final Database database;
    public LibraryService(Database database) {
        this.database = database;
    }

    static long counter = 0;

    public static long id(){
        counter++;
        return counter;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        database.libraries = libraries;
        for (int i = 0; i < database.libraries.size(); i++) {
            database.libraries.get(i).setId(id());
        }
        return database.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (int i = 0; i < database.libraries.size(); i++) {
            if(database.libraries.get(i).getId() == id){
                return database.libraries.get(i);
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        boolean isTrue = true;
        for (int i = 0; i < database.libraries.size(); i++) {
            if(database.libraries.get(i).getId() == id ){
                database.libraries.set(i, library);
                database.libraries.get(i).setId(id);
                System.out.println("Succesfully updated library with id " + id);
                return database.libraries.get(i);
            }else isTrue = false;
        }
        if(isTrue==false) System.out.println("Library with id " + id + " not found!");
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        boolean isTrue = true;
        for (int i = 0; i < database.libraries.size(); i++) {
            if(database.libraries.get(i).getId() == id){
                database.libraries.remove(database.libraries.get(i));
                return "Library with id " + id + " succesfully deleted!";
            }else isTrue = false;
        }
        if(isTrue == false) System.out.println("Library with " + id + " not found!");
        return null;
    }
}
