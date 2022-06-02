package cinema.model;

import cinema.exception.AlreadyBooked;
import cinema.exception.OutOfBoundsException;
import cinema.exception.WrongTokenException;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.*;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    Collection<Seat> availableSeats;
    Map<String, SoldSeat> soldSeats = new HashMap<>();
//    private Set<Seat> soldSeats = new HashSet<>();

    public CinemaRoom(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        availableSeats = new LinkedHashSet<>(totalRows * totalColumns);
        for (int row = 1; row <= totalRows; row++) {
            for (int column = 1; column <= totalColumns; column++) {
                availableSeats.add(new Seat(row, column));
            }
        }
    }

//    public Map<String, SoldSeat> getSoldSeats() {
//        return soldSeats;
//    }

//   public void setSoldSeats(Map<String, SoldSeat> soldSeats) {
//        this.soldSeats = soldSeats;
//    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public Collection<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Collection<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public SoldSeat sell(Seat seat) {


        synchronized (this) {
            if (seat.getColumn() < 1 || totalColumns < seat.getColumn() ||
                    seat.getRow() < 1 || totalRows < seat.getRow()) {
                throw new OutOfBoundsException();
            }

            if (!availableSeats.remove(seat)) {
                throw new AlreadyBooked();
            }

            var soldSeat = new SoldSeat(seat);
            soldSeats.put(soldSeat.getToken(), soldSeat);
            return soldSeat;
        }
    }

    public Seat returnTicket(String token) {
        synchronized (this) {
//            for (var seat : soldSeats.keySet()){
//                if(!seat.equals(token.getToken())){
//                    throw new WrongTokenException();
//                }
//            }

            if (!soldSeats.containsKey(token)) {
                throw new WrongTokenException();
            }
            var ticket = soldSeats.remove(token).getTicket();
            availableSeats.add(ticket);
            return ticket;

        }
    }
}
