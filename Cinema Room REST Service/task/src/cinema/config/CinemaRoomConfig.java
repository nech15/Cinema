package cinema.config;

import cinema.model.CinemaRoom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
public class CinemaRoomConfig {
    @Bean
    CinemaRoom cinemaRoom(
            @Value("${cinema.room.rows}") int rows,
            @Value("${cinema.room.cols}") int columns) {
        return new CinemaRoom(rows, columns);
    }
}
