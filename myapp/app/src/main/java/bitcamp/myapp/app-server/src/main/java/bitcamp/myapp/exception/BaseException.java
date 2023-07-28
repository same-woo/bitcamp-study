// package bitcamp.myapp.exception;
//
// import bitcamp.net.ResponseEntity;
//
// public abstract class BaseException extends RuntimeException {
//
// private String MESSAGE;
// private int HTTP_STATUS_CODE;
//
// private BaseException() {
//
// }
//
// public BaseException(int statusCode, String message, Throwable cause) throws Exception {
// super(message);
// super(cause);
// this.MESSAGE = message;
// this.HTTP_STATUS_CODE = statusCode;
// }
//
// public String getMsg() {
// return this.MESSAGE;
// }
//
// public int getCode() {
// return this.HTTP_STATUS_CODE;
// }
//
// }
//
//
// class Advicer {
// public ResponseEntity aaaa(BaseException a) {
// // 로그 로직 log4j
// log
// return ResponseEntity.code(a.getCode()).body(a.getMsg());
// }
// }
//
// {code:404,body:"리소스 없음"}
//
//
// class NotFoundException extends BaseException {
// private String message = "리소스 없음";
// private int code = 404;
//
// public NotFoundException() {
// super(404, "리소스 없음");
// }
// }
