package com.eomcs.openapi.json.jackson;

import java.sql.Date;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class Exam_0210 {
  public static void main(String[] args) throws Exception {

    // 1) 객체 준비
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));

    // 2) JSON 처리 객체 준비
    ObjectMapper mapper = new ObjectMapper();

    // 날짜 형식을 "yyyy-MM-dd"로 설정
    mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));

    // 3) 객체의 값을 JSON 문자열로 얻기
    String jsonStr = mapper.writeValueAsString(m);

    System.out.println(jsonStr);
  }
}
