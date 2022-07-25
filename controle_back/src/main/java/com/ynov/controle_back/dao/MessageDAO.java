package com.ynov.controle_back.dao;

import com.ynov.controle_back.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO extends JpaRepository<Message, Integer> {

    Message findById(int id);
    List<Message> findByTexteLike(String recherche);

    @Query("update Message set date = '2020-12-21 23:56:12'")
    Message customeQuery(Message message);
}
