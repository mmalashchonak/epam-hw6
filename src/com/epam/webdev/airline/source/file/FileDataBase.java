package com.epam.webdev.airline.source.file;

import com.epam.webdev.airline.entity.plane.AbstractPlane;
import com.epam.webdev.airline.source.file.exception.FileLoadException;
import com.epam.webdev.airline.source.file.exception.FileSaveException;

import java.io.*;
import java.util.List;

public class FileDataBase {

    private static final String FILE_PATH = "src\\resources\\planes.txt";

    private static FileDataBase instance;

    private FileDataBase() {
    }

    public static synchronized FileDataBase getInstance() {
        if(instance == null) {
            instance = new FileDataBase();
        }
        return instance;
    }

    public List<AbstractPlane> loadAllPlanes() throws FileLoadException {
        List<AbstractPlane> planes;
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            planes = (List<AbstractPlane>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileLoadException("File can not be read correctly.", e);
        }
        return planes;
    }

    public boolean saveAllPlanes(List<AbstractPlane> planes) throws FileSaveException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(planes);
        } catch (IOException e) {
            throw new FileSaveException("Can not write to file.", e);
        }
        return true;
    }
}
