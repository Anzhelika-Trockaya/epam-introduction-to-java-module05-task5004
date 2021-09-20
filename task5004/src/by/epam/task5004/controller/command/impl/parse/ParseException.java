package by.epam.task5004.controller.command.impl.parse;

public class ParseException extends Exception {
    public ParseException() {
        super();
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(Exception exception) {
        super(exception);
    }

    public ParseException(String message, Exception exception) {
        super(message, exception);
    }
}
