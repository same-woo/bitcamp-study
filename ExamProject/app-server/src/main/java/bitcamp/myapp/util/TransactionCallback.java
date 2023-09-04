package bitcamp.myapp.util;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;


// 트랜잭션으로 처리 할 작업을 갖고 있는 객체 사용법
public interface TransactionCallback {
    Object doInTransaction(TransactionStatus status);


}
