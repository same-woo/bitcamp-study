package bitcamp.myapp.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.myapp.vo.MyDog; // Update the import statement to use MyDog instead of User

public class MySQLDogDao implements DogDao { // Update the class name from MySQLDogDao to MySQLDogDao

    SqlSessionFactory sqlSessionFactory;

    public MySQLDogDao(SqlSessionFactory sqlSessionFactory) { // Update the constructor name from MySQLDogDao to MySQLDogDao
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(MyDog myDog) { // Update parameter and method signature from User to MyDog
        	SqlSession sqlSession = sqlSessionFactory.openSession(false);
            sqlSession.insert("bitcamp.myapp.dao.DogDao.insert", myDog); // Update parameter from User to MyDog
        }

    @Override
    public List<MyDog> findAll() { // Update return type from List<User> to List<MyDog>
        	SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession.selectList("bitcamp.myapp.dao.DogDao.findAll");
        }

    @Override
    public MyDog findBy(int dog_no) { // Update parameter and return type from int/User to int/MyDog
        	SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession.selectOne("bitcamp.myapp.dao.DogDao.findBy", dog_no); // Update parameter from int/User to int/MyDog
        }

    @Override
    public MyDog findByEmailAndPassword(MyDog myDog) { // Update parameter and return type from User to MyDog
			SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession.selectOne("bitcamp.myapp.dao.DogDao.findByEmailAndPassword", myDog); // Update parameter from User to MyDog
        }

    @Override
    public int update(MyDog myDog) { // Update parameter and return type from User to MyDog
        	SqlSession sqlSession = sqlSessionFactory.openSession(false);
        	return sqlSession.update("bitcamp.myapp.dao.DogDao.update", myDog); // Update parameter from User to MyDog
        }

    @Override
    public int delete(int dog_no) { // Update parameter and return type from int/User to int/MyDog
        	SqlSession sqlSession = sqlSessionFactory.openSession(false);
        	return sqlSession.delete("bitcamp.myapp.dao.DogDao.delete", dog_no); // Update parameter from int/User to int/MyDog
    }
}
