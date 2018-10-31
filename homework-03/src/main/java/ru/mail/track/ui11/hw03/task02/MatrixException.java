package ru.mail.track.ui11.hw03.task02;

/**
 * Indicates that 2-D array is not a matrix.
 *
 */
public class MatrixException extends RuntimeException {

    public MatrixException() {
    }

    public MatrixException(String string) {
        super(string);
    }
}
