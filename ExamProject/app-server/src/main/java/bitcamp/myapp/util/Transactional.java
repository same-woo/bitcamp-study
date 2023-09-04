package bitcamp.myapp.util;

public @interface Transactional {
    String value() default "tx1";

}
