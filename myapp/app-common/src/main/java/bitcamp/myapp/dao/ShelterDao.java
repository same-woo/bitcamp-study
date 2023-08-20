package bitcamp.myapp.dao;

import java.util.List;

import bitcamp.myapp.vo.Shelter; // Update the import statement to match the correct package

public interface ShelterDao {
    void insert(Shelter shelter);

    List<Shelter> findAll();

    Shelter findByNo(int shelterNo);

    int update(Shelter shelter);

    int delete(int shelterNo);
}

