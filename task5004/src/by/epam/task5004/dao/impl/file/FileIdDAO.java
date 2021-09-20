package by.epam.task5004.dao.impl.file;

import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.IdDAO;
import by.epam.task5004.service.impl.FileIdGenerator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIdDAO implements IdDAO {

    private final String fileName = String.valueOf(
            FileIdGenerator.class.getResource("/by/epam/task5004/resource/currentId.txt")).substring(6);

    public int loadCurrentId() throws DAOException {
        String idString = "";
        int id;

        try (FileReader reader = new FileReader(fileName)) {
            while (reader.ready()) {
                idString += (char) reader.read();
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }

        idString = idString.replaceAll(" ", "");
        id = Integer.parseInt(idString);

        return id;
    }

    public void unloadCurrentId(int currentId) throws DAOException {
        String idString;

        idString = Integer.toString(currentId);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(idString);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
