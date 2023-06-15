package bitcamp.myapp.project.handler;

// 핸들러 사용규칙
// 메서드 호출 규칙을 정의
// 시그니처 메서드명 파라미터 목록
// 메서드 몸체는 작성하지 않는다.
// 왜 ? 호출 규칙만 정의하는 것이기 때문이다.

public interface Handler {
  public abstract void execute();

}
