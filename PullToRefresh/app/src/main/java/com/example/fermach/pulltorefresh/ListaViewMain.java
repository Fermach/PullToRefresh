package com.example.fermach.pulltorefresh;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.baoyz.widget.PullRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class ListaViewMain extends AppCompatActivity {

    private View view;
    private List<Asignatura> listaAsignaturas;
    private ListView listaView;
    private PullRefreshLayout pullLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);

        //Inicializamos las vistas
        view=findViewById(R.id.vista_principal);
        listaView = findViewById(R.id.lista);
        pullLayout = findViewById(R.id.pulltoRefresh);

        //rellenamos la listacon objetos de tipo Asignatura
        listaAsignaturas = new ArrayList<>();
        mockDatos();


        //seteamos el adaptador de la lista pasándole el color
        //de fondo que tendran los cardviews
        listaView.setAdapter(new ListaAdapter(this,
                listaAsignaturas,Color.parseColor("#7E88CF")));

        /* Metodo de la libreria PullToRefresh en el cual controlamos la accion
         * de nuestra aplicación al deslizar la lista hacia abajo
         *
         */
        pullLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // lanzamos un hilo que esperará durante 3 s
                pullLayout.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                // a los 3 s seteará el adaptador con un color verde diferente
                                // y mostrará un snackbar
                                listaView.setAdapter(new ListaAdapter(getApplicationContext(),
                                        listaAsignaturas, Color.parseColor("#B1CF7E")));
                                Snackbar.make(view,"" +
                                                "¡¡ENHORABUENA!!\n Has aprobado todas las asignaturas!!",
                                        Snackbar.LENGTH_LONG).show();

                                //después detendremos la animación de PullToRefresh
                                pullLayout.setRefreshing(false);
                            }
                        }, 3000);


            }

        });
    }

    public void mockDatos(){
        Asignatura interfaces= new Asignatura("Desarrollo de Interfaces", "Luis Jose Molina Garzon");
        Asignatura accesoDatos= new Asignatura("Acceso a Datos", "Juan Gualberto Gutierrez Marin");
        Asignatura programacionServicios= new Asignatura("Programación de servicios y procesos", "Manuel Molino Milla");
        Asignatura programacionMultimedia= new Asignatura("Programación multimedia y dispositivos moviles", "Jacinto D. Cabrera");
        Asignatura sistemas= new Asignatura("Sistemas de gestión empresarial", "Juanjo Serrano");
        Asignatura empresas= new Asignatura("Proyecto e inciciativa emprendedora", "Guadalupe");

        listaAsignaturas.add(interfaces);
        listaAsignaturas.add(accesoDatos);
        listaAsignaturas.add(programacionServicios);
        listaAsignaturas.add(programacionMultimedia);
        listaAsignaturas.add(sistemas);
        listaAsignaturas.add(empresas);

    }

    /**
     * Inflamos el menu con el layout que hemos creado
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }

    /**
     * Dependiendo del item del menú selecionado setteamos una animación u otra
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        switch (id){
            case R.id.mn_material:
                pullLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
                return  true;
            case R.id.mn_circles:
                pullLayout.setRefreshStyle(PullRefreshLayout.STYLE_CIRCLES);
                return  true;
            case R.id.mn_water:
                pullLayout.setRefreshStyle(PullRefreshLayout.STYLE_WATER_DROP);
                return  true;
            case R.id.mn_ring:
                pullLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
                return  true;
            case R.id.mn_smartisan:
                pullLayout.setRefreshStyle(PullRefreshLayout.STYLE_SMARTISAN);
                return  true;

        }
        return  super.onOptionsItemSelected(item);
    }
}
