package com.example.stephanie.bem_vindos_a_ua_official;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Stephanie on 03/06/2017.
 */


public class ListaEdificiosActivity extends AppCompatActivity{

    String[] c_names = {"Departamento de Comunicação e Arte", "Complexo das Ciências da Comunicação e Imagem","Departamento de Educação e Psicologia", "Biblioteca", "Departamento de Matemática", "Departamento de Ciências Sociais, Políticas e do Território",
    "Departamento de Física", "Complexo de Laboratórios Tecnológicos", "Departamento de Economia, Gestão e Engenharia Industrial e Turismo", "Complexo Pedagógico, Cientifico e Tecnológico",
    "Laboratório Central de Análises", "Departamento de Geociências", "Departamento de Engenharia Civil",
    "Departamento de Engenharia Mecâcina", "Serviços de Tecnologias de Informação e Comunicação",
    "Catacumbas da Universidade de Aveiro", "Livraria e Sala de Exposições", "Departamento de Ambiente e Ordenamento",
    "Departamento de Electrónica, Telecomunicações e Informática", "Departamento de Biologia da Universidade de Aveiro",
    "Departamento de Engenharia de Materiais e Cerâmica", "IEETA", "IT-Instituto de Telecomunicações", "Departamento de Línguas e Culturas",
    "Instituto Confúcio", "CESAM-Centro de Estudos do Ambiente e do Mar", "IEUA - Incubadora de Empresas da Universidade de Aveiro",
    "IDAD - Instituto do Ambiente e Desenvolvimento", "GRETUA - Grupo Experimental de Teatro da UA",
    "Residência de Docentes, Funcionários e Estudantes de Pós-graduação", "ISCA-UA- Instituto Superior de Contabilidade e Administração da Universidade de Aveiro",
    "Reitoria", "Pavilhão Polidesportivo Prof.Dr.Aristides Hall"
    };

//    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Edificio> arrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_edificios);

        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        toolbar = (Toolbar) findViewById(R.id.toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;

        for (String Name : c_names) {
            arrayList.add(new Edificio(Name));
        }

        recyclerAdapter  = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // When the home button is pressed, take the user back to the VisualizerActivity
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
    public void getActionDeca(View view) {
        startActivity(new Intent(this, DecaActivity.class));
    }
}
