package com.java.automation.lab.fall.grinecivh.core22.domain.classes.io;

import java.io.*;

public class ObjectIO<T> {

    public void write(T obj, String path) {
        try (
                FileOutputStream fos = new FileOutputStream(new File(path).getAbsoluteFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(obj);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public T read(String path) {
        try (
                FileInputStream fis = new FileInputStream(new File(path).getAbsoluteFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
