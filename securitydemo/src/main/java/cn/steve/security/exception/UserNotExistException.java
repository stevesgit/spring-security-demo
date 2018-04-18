package cn.steve.security.exception;

/**
 * Created By SteveWoo
 */
public class UserNotExistException extends RuntimeException {
    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }
}
