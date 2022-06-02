package cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AlreadyBooked extends BusinessLogicException {

    public AlreadyBooked() {
        super("The ticket has been already purchased!");
    }
}
