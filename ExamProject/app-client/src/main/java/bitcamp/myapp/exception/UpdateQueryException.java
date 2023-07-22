package bitcamp.myapp.exception;

public class UpdateQueryException extends RuntimeException {
  private static final String MESSAGE = "업데이트 도중 Exception발생";

  public UpdateQueryException() {
    super(MESSAGE);
  }

}
