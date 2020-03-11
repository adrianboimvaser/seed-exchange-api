package com.example.mapper;

import com.example.domain.Seed;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SeedMapper {

    List<Seed> list();

    void insert(Seed seed);

    Seed findById(long id);

    void update(Seed seed);

    void delete(long id);
}
