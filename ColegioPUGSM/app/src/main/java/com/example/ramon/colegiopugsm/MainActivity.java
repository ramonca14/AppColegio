package com.example.ramon.colegiopugsm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private BottomNavigationView bottomNavigationView;
    private TextView infotextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //para el logo del bar;
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        infotextView = (TextView) findViewById(R.id.txtview);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottonNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item) {
                //esto se ejecuta si se selecciona un item del menu inferior
                if (item.getItemId()==R.id.webItem){
                    //WebView webView = (WebView) findViewById(R.id.webview);
                    //webView.loadUrl("https://www.unlar.edu.ar/");

                  Uri uriUrl = Uri.parse("https://www.unlar.edu.ar/");
                  Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                  startActivity(intent);
                    return true;
                }else if (item.getItemId()==R.id.evaItem){
                    infotextView.setText(R.string.unlartext);
                    return true;
                }else if (item.getItemId()==R.id.colegioItem){

                    infotextView.setText(R.string.colegiotext);
                    return true;

                }else if (item.getItemId()==R.id.Itemcalendario){
                    infotextView.setText(R.string.calendariotext);
                    return true;
                }else if (item.getItemId()==R.id.Itemcontacto){
                    infotextView.setText(R.string.llamartext);
                    return true;
                }

                return false;
            }

        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //* Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_ins) {
            //  fragmentManager.beginTransaction().replace(R.id.flprincipal, new android.support.v4.app.InstitucionFrgm()).commit;
            Toast.makeText(this, "Informacion de la Institucion", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_aut) {
            Toast.makeText(this, "Autoridades de la Institucion", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_proyect) {
            Toast.makeText(this, "Proyectos Institucionales", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_modal) {
            Toast.makeText(this, "Conoce las diferentes modalidades", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_galery) {
            Toast.makeText(this, "Galeria de Imagenes", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_contact) {
            Toast.makeText(this, "Hacer llamadas a Contactos", Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_leng) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
