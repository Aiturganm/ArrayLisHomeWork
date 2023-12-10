package arraylist.methods.impl;

import arraylist.database.Database;
import arraylist.models.Reader;

import java.util.List;

public class ReaderService implements arraylist.methods.ReaderService {
    public final Database database;
    public ReaderService(Database database) {
        this.database = database;
    }

    static long counter = 0;

    public static long id(){
        counter++;
        return counter;
    }
    @Override
    public void saveReader(Reader reader) {
        database.readers.add(reader);
        database.readers.get(database.readers.size()-1).setId(id());
        System.out.println("Reader succesfully saved!");
    }

    @Override
    public List<Reader> getAllReaders() {
        return database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        boolean isTrue = true;
        for (int i = 0; i < database.readers.size(); i++) {
            if(database.readers.get(i).getId() == id){
                return database.readers.get(i);
            }else isTrue = false;
        }
        if(isTrue == false){
            System.out.println("Reader with id " + id + " not found!");
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        boolean isTrue = true;
        for (int i = 0; i < database.readers.size(); i++) {
            if(database.readers.get(i).getId() == id){
                database.readers.set(i, reader);
                database.readers.get(i).setId(id);
                return reader;
            }else isTrue = false;
        }
        if(isTrue == false){
            System.out.println("Reader with id " + id + " not found!");
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        boolean isTrue = true;
        for (int i = 0; i < database.readers.size(); i++) {
            if(database.readers.get(i).getId() == readerId){
                for (int j = 0; j < database.libraries.size(); j++) {
                    if(database.libraries.get(j).getId() == libraryId){
                        System.out.println(database.readers.get(i).getFullName() + " succesfully assigned to library " + database.libraries.get(j).getName());
                        database.libraries.get(j).setReaders(database.readers.get(i));
                    }
                }
            }else isTrue = false;
        }
        if(isTrue == false){
            System.out.println("Reader with id " + readerId + " not found!");
        }
    }
}
