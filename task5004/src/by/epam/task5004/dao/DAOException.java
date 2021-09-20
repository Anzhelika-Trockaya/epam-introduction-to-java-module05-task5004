package by.epam.task5004.dao;

public class DAOException extends Exception {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(Exception e, String message) {
        super(message, e);
    }
}
