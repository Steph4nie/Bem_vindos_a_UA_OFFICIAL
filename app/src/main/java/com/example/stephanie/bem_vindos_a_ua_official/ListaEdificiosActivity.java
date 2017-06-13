package com.example.stephanie.bem_vindos_a_ua_official;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by Stephanie on 03/06/2017.
 */


public class ListaEdificiosActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    String[] c_names = {"DECA - Departamento de Comunicação e Arte", "CCCI - Complexo das Ciências da Comunicação e Imagem","CIFOP - Departamento de Educação e Psicologia", "Biblioteca", "DEMAT - Departamento de Matemática", "DCSPT - Departamento de Ciências Sociais, Políticas e do Território",
    "DFIS - Departamento de Física", "Complexo de Laboratórios Tecnológicos", "DEGEIT - Departamento de Economia, Gestão e Engenharia Industrial e Turismo", "Complexo Pedagógico, Cientifico e Tecnológico",
    "Laboratório Central de Análises", "DGEO - Departamento de Geociências", "DECIVIL - Departamento de Engenharia Civil",
    "DEM - Departamento de Engenharia Mecâcina", "STIC - Serviços de Tecnologias de Informação e Comunicação",
    "CUA - Catacumbas da Universidade de Aveiro", "Livraria e Sala de Exposições", "DAO - Departamento de Ambiente e Ordenamento",
    "DETI - Departamento de Electrónica, Telecomunicações e Informática", "DBIO - Departamento de Biologia da Universidade de Aveiro",
    "DEMAC - Departamento de Engenharia de Materiais e Cerâmica", "IEETA", "IT-Instituto de Telecomunicações", "DLC - Departamento de Línguas e Culturas",
    "Instituto Confúcio", "CESAM-Centro de Estudos do Ambiente e do Mar", "IEUA - Incubadora de Empresas da Universidade de Aveiro",
    "IDAD - Instituto do Ambiente e Desenvolvimento", "GRETUA - Grupo Experimental de Teatro da UA",
    "Residência de Docentes, Funcionários e Estudantes de Pós-graduação", "ISCA-UA- Instituto Superior de Contabilidade e Administração da Universidade de Aveiro",
    "Reitoria", "Pavilhão Polidesportivo Prof.Dr.Aristides Hall"
    };

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Edificio> arrayList = new ArrayList<>();
    SearchView sv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_edificios);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar toolbar = this.getSupportActionBar();

        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;

        for (String Name : c_names) {
            arrayList.add(new Edificio(Name));
        }

        recyclerAdapter  = new RecyclerAdapter(arrayList, this);
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
//    pub
// lic void getActionDecaClick(View view) {
//        //startActivity(new Intent(this, DecaActivity.class));
//        for (Edificio edificio: arrayList) {
//            String name = edificio.getName();
//            if (name.contains("DFIS - Departamento de Física"))
//                Toast.makeText(this, ("DFIS - Departamento de Física" + "carregado"), Toast.LENGTH_SHORT).show();
//        }
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText)  {
        newText = newText.toLowerCase();
        ArrayList<Edificio> newList = new ArrayList<>();
        for (Edificio edificio: arrayList) {
            String name = edificio.getName().toLowerCase();
            if (name.contains(newText))
                newList.add(edificio);
        }
        recyclerAdapter.setFilter(newList);
        return true;

    }

// TODO HANDLE CLICKS ON RECYCLERVIEW  https://www.youtube.com/watch?v=xEHHdpxW7iA
}
