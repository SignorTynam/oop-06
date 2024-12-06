package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {
    
    public NetworkException() throws IOException {
        throw new IOException("Errore di rete: nessuna risposta");
    }

    public NetworkException(String message) throws IOException {
        throw new IOException("Errore di rete durante l’invio del messaggio: " + message);
    }
    
}
