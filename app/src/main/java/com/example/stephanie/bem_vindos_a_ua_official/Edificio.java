package com.example.stephanie.bem_vindos_a_ua_official;

/**
 * Created by Stephanie on 09/06/2017.
 */

public class Edificio {
    private String name;

    public Edificio(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
