package com.bingo.util;

/**
 * Se crea la clase Response con el objetivo de generar diferentes respuestas para la aplicacion.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
public class Response {
    /**
     * The Error.
     */
    public Boolean error = false;
    /**
     * The Message.
     */
    public String message = "";
    /**
     * The Status.
     */
    public String status = "OK";
    /**
     * The Data.
     */
    public Object data;
}
