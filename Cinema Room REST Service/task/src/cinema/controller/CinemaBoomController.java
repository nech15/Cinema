package cinema.controller;

import cinema.exception.BusinessLogicException;
import cinema.model.CinemaRoom;
import cinema.model.Seat;
import cinema.model.SoldSeat;
import cinema.model.Token;
import cinema.model.response.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaBoomController {
    @Autowired
    CinemaRoom cinemaRoom;

    @GetMapping("/seats")
    public CinemaRoom seats() {
        return cinemaRoom;
    }

    @PostMapping("/purchase")
    public SoldSeat purchase(@RequestBody Seat seat) {
        SoldSeat soldSeat = cinemaRoom.sell(seat);
        return soldSeat;
    }

    @PostMapping("/return")
    public Seat returnTicket(@RequestBody String token) {
       Seat seat = cinemaRoom.returnTicket(token);
       return seat;
    }

    @ExceptionHandler(BusinessLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorDTO errorHandler(Exception e){
        return new ErrorDTO(e.getMessage());
    }





}
