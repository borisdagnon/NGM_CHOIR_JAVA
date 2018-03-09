package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Louange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoLouange extends CrudRepository<Louange,Integer> {

    List<Louange> findAll();

    List<Louange> findByNomContaining(String nom);
}

