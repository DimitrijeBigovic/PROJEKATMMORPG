package exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerException extends Exception {

    public PlayerException(String message) {
        super(message);
    }
}
