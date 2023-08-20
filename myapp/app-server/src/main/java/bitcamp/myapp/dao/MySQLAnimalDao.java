package bitcamp.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.myapp.vo.ShelterAnimal;

public class MySQLAnimalDao implements AnimalDao {

    SqlSessionFactory sqlSessionFactory;

    public MySQLAnimalDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(ShelterAnimal shelterAnimal) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        sqlSession.insert("bitcamp.myapp.dao.AnimalDao.insert", shelterAnimal);
    }

    @Override
    public List<ShelterAnimal> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("bitcamp.myapp.dao.AnimalDao.findAll");
    }

    @Override
    public ShelterAnimal findBy(int shelterAnimalNo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("bitcamp.myapp.dao.AnimalDao.findBy", shelterAnimalNo);
    }

    @Override
    public ShelterAnimal findByEmailAndPassword(ShelterAnimal shelterAnimal) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("bitcamp.myapp.dao.AnimalDao.findByEmailAndPassword", shelterAnimal);
    }

    @Override
    public int update(ShelterAnimal shelterAnimal) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.update("bitcamp.myapp.dao.AnimalDao.update", shelterAnimal);
    }

    @Override
    public int delete(int shelterAnimalNo) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.delete("bitcamp.myapp.dao.AnimalDao.delete", shelterAnimalNo);
    }
}
