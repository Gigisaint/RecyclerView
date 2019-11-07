package org.giselle.recyclerview.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PokemonShort.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
}