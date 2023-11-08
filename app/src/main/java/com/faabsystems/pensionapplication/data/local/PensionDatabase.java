package com.faabsystems.pensionapplication.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.faabsystems.pensionapplication.data.local.dao.UserDao;
import com.faabsystems.pensionapplication.data.local.entity.UserEntity;


@Database(entities = {UserEntity.class}, version = 1)
    public abstract class PensionDatabase extends RoomDatabase {
        public abstract UserDao userDao();
    }
