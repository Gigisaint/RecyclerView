package org.giselle.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.giselle.recyclerview.adapter.PokemonAdapter;
import org.giselle.recyclerview.adapter.PokemonItemListener;
import org.giselle.recyclerview.data.AppDatabase;
import org.giselle.recyclerview.data.PokemonShort;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity implements PokemonItemListener {
    private PokemonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(), 3);
        recyclerView.setLayoutManager(manager);
        adapter = new PokemonAdapter(new ArrayList<PokemonShort>(), this);
        recyclerView.setAdapter(adapter);
    }
    private void updatePokemonList(List<PokemonShort> pokemonShortList) {
        adapter.setItems(pokemonShortList);
    }

    public void addPokemon(View view) {
        Intent intent = new Intent(this, AddPokemonActivity.class);
        startActivity(intent);
    }

    public static class AppDataBaseSingleton {
        public static AppDataBaseSingleton instance = null;
        public AppDatabase appDatabase;
        private AppDataBaseSingleton(Context context) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "pokemon").build();
        }
        public static AppDataBaseSingleton getInstance(Context context) {
            if (instance == null) {
                instance = new AppDataBaseSingleton(context);
            }
            return instance;
        }
    }

    public static final String EXTRA_DATA = "EXTRA_DATA";
    @Override
    public void onPokemonClicked(int position) {
        PokemonShort pokemonShort = adapter.getItem(position);
        Intent intent = new Intent(this, PokemonDetailActivity.class);
        intent.putExtra(EXTRA_DATA, pokemonShort);
        startActivity(intent);
    }
}
