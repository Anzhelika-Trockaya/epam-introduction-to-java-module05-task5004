package by.epam.task5004.dao.impl.file;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.TreasuresDAO;
import by.epam.task5004.dao.impl.file.parse.parser.TreasureParser;
import by.epam.task5004.dao.impl.file.string.TreasureToStringCommand;
import by.epam.task5004.dao.impl.file.string.TreasureToStringCommandProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTreasuresDAO implements TreasuresDAO {

    private static final String fileName;

    private BufferedReader reader;

    static {
        fileName = String.valueOf(
                FileTreasuresDAO.class.getResource("/by/epam/task5004/resource/treasures.txt"))
                .substring(6);
    }

    public FileTreasuresDAO() {
    }

    @Override
    public Treasure getNext() throws DAOException {
        String treasureString;
        Treasure nextTreasure;
        TreasureParser parser;

        parser = TreasureParser.getInstance();

        try {
            if (reader == null) {
                reader = new BufferedReader(new FileReader(fileName));
            }

            if (reader.ready()) {
                treasureString = reader.readLine();
                nextTreasure = parser.parse(treasureString);
            } else{
                nextTreasure=null;
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return nextTreasure;
    }

    @Override
    public void add(Treasure treasure) throws DAOException {
        String treasureString;
        TreasureToStringCommandProvider provider;
        TreasureToStringCommand treasureToStringCommand;

        closeReader();

        provider = new TreasureToStringCommandProvider();
        treasureToStringCommand = provider.getCommand(treasure.getClass().getSimpleName());
        treasureString = treasureToStringCommand.execute(treasure);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("\n"+treasureString);
            writer.flush();
        } catch (IOException exception) {
            throw new DAOException(exception);
        }
    }

    private void closeReader() throws DAOException {
        if (reader != null) {
            try {
                reader.close();
                reader = null;
            } catch (IOException exception) {
                throw new DAOException(exception);
            }
        }
    }

    @Override
    public void deleteIfExist(int id) throws DAOException {
        List<String> treasuresLines;
        String currentLine;
        boolean exist;

        closeReader();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {

            treasuresLines = new ArrayList<>();
            exist = false;

            while (reader1.ready()) {
                currentLine = reader1.readLine();

                if (!currentLine.contains(" id=" + id + " ")) {
                    treasuresLines.add(currentLine);
                } else {
                    exist = true;
                }
            }

        } catch (IOException exception) {
            throw new DAOException(exception);
        }

        if (exist) {
            writeLines(treasuresLines);
        }

    }

    private void writeLines(List<String> lines) throws DAOException {

        closeReader();

        if(!lines.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

                for (int i = 0; i < lines.size() - 1; i++) {
                    writer.write(lines.get(i));
                    writer.newLine();
                }

                writer.write(lines.get(lines.size()-1));

            } catch (IOException exception) {
                throw new DAOException(exception);
            }
        }
    }

    @Override
    public List<Treasure> getAll() throws DAOException {
        List<Treasure> treasures;
        String currentLine;

        TreasureParser parser;
        Treasure currentTreasure;

        closeReader();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {

            treasures = new ArrayList<>();
            parser = TreasureParser.getInstance();

            while (reader1.ready()) {
                currentLine = reader1.readLine();
                currentTreasure = parser.parse(currentLine);
                treasures.add(currentTreasure);
            }

            return treasures;

        } catch (IOException exception) {
            throw new DAOException(exception);
        }

    }
}
