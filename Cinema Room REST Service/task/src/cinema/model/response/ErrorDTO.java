package cinema.model.response;

public class ErrorDTO {

    String error;
    public ErrorDTO(String error){
        this.error = error;
    }

    public String getError(){
        return error;
    }
}
