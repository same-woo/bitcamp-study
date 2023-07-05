package bitcamp.myapp.project.dao;

import java.util.List;
import bitcamp.myapp.project.vo.Member;

public interface MemberDao {
  void insert(Member member);

  List<Member> list();

  Member findBy(int no);

  int update(Member member);

  int delete(int no);
}
