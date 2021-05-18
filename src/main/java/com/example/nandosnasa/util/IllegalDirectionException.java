/**
 * @Author Richard Renaud
 * <p>
 * If rover receives an instruction which is not [L, R, M] throw IllegalDirectionException.
 */
package com.example.nandosnasa.util;

public class IllegalDirectionException extends RuntimeException {

    public IllegalDirectionException(String message) {
        super(message);
    }
}
