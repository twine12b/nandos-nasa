/**
 * @Author Richard Renaud
 * <p>
 * If rover receives no moves, throw NoDirectionFoundException.
 */
package com.example.nandosnasa.util;

public class NoDirectionFoundException extends RuntimeException {

    public NoDirectionFoundException(String message) {
        super(message);
    }
}
