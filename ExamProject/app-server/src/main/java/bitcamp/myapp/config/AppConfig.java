package bitcamp.myapp.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.util.Bean;
import bitcamp.util.SqlSessionFactoryProxy;

// Application
@ComponentScan(basePackages = {"bitcamp.myapp.dao", "bitcamp.myapp.Handler"})
public class AppConfig {

  // Mybatis 객체 준비

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    return new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml")));
  }

}
