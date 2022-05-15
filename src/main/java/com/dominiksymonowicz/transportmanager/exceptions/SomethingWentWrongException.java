package com.dominiksymonowicz.transportmanager.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This a generic exception use in  exercises and examples which is a placeholder for specific exception that I wll normally used.
 */
@SuppressWarnings("WeakerAccess")
@Slf4j
public class SomethingWentWrongException extends RuntimeException {

    private static final String ERROR = "Whoops! Something went wrong. %s. I apologize for any inconvenience caused by your mistake.";

    public SomethingWentWrongException(String whatWentWrongMessage) {
        super(format(ERROR, whatWentWrongMessage));
        log.error(whatWentWrongMessage);
    }

    public SomethingWentWrongException(String whatWentWrongMessage, Throwable cause) {
        super(format(ERROR, whatWentWrongMessage), cause);
        log.error(whatWentWrongMessage,cause);
    }

    //https://www.owasp.org/index.php/Deserialization_Cheat_Sheet
    @Serial
    @SuppressWarnings({"FinalPrivateMethod", "unused"})
    private final void readObject(ObjectInputStream in) throws IOException {
        throw new IOException("Cannot be deserialized");
    }

    @Serial
    @SuppressWarnings({"FinalPrivateMethod", "unused"})
    private final void writeObject(ObjectOutputStream out) throws IOException {
        throw new IOException("Cannot be serialized");
    }
}
