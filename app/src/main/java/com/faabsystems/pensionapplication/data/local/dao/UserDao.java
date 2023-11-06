package com.faabsystems.pensionapplication.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.faabsystems.pensionapplication.data.local.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(UserEntity entity);

    @Query("SELECT * FROM user_table")
    List<UserEntity> getAllEntities();
}