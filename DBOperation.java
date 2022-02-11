package com.liveasy.liveasy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DBOperation extends JpaRepository<Shipping,Integer> {

    @Query("SELECT u FROM Shipping u WHERE u.shipperId = ?1")
    public List<Shipping> findList(String Keyword);

}
