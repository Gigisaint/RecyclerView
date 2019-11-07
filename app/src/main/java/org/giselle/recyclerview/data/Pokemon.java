package org.giselle.recyclerview.data;

import java.util.List;

public class Pokemon {
    int id;
    int height;
    int baseExpirience;
    int weight;
    List<String> types;
    String url;
    String name;

    public Pokemon(int id, int height, int baseExpirience, int weight, List<String> types, String url, String name) {
        this.id = id;
        this.height = height;
        this.baseExpirience = baseExpirience;
        this.weight = weight;
        this.types = types;
        this.url = url;
        this.name = name;
    }
}
