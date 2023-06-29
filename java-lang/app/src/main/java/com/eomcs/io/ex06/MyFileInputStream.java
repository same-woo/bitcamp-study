package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream extends FileInputStream {

  byte[] buf = new byte[8192]; // 8KB
  int length; // 버퍼에 저장한 바이트 수
  int pos; // 읽을 바이트의 인덱스

  public MyFileInputStream(String name) throws FileNotFoundException {
    super(name);


  }

  @Override
  public int read() throws IOException {
    if (pos == length) { // 버퍼 데이터를 다 읽었다면,
      length = this.read(buf); // 버퍼 크기만큼 파일에서 데이터를 읽어들인다.
      if (length == -1) {
        length = 0;
        return -1;
      }
      pos = 0; // 버퍼 시작부터 읽을 수 있도록 위치를 0으로 설정한다.
      System.out.println(length + " byte read !");
    }
    return buf[pos++] & 0x000000ff;
  }

  public static void main(String[] args) {
    BufferedFileInputStream
  }

}
