package colegio;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import colegio.activity.CustomListViewActivity;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    public static String weburl = "http://cpugsm.comunidadeduar.com.ar";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottonNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.colegioItem);
        Toast.makeText(this, "Cargando....espere por favor", Toast.LENGTH_LONG).show();
        WebViewFragment webViewFragment = new WebViewFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.idcontenido, webViewFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item) {

                if (item.getItemId()==R.id.webItem){
                    weburl = "http://cpugsm.unlar.edu.ar";
                    WebViewFragment webViewFragment = new WebViewFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.idcontenido, webViewFragment).commit();
                    return true;
                }else if (item.getItemId()==R.id.evaItem){
                    weburl = "http://catedras.unlar.edu.ar";
                    WebViewFragment webViewFragment = new WebViewFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.idcontenido, webViewFragment).commit();
                    return true;
                }else if (item.getItemId()==R.id.colegioItem){
                    weburl = "http://cpugsm.comunidadeduar.com.ar";
                    WebViewFragment webViewFragment = new WebViewFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.idcontenido, webViewFragment).commit();
                    return true;

                }else if (item.getItemId()==R.id.Itemcalendario){

                    WebViewPdf webViewPdf= new WebViewPdf();
                    getSupportFragmentManager().beginTransaction().replace(R.id.idcontenido, webViewPdf).commit();
                    return true;

                }else if (item.getItemId()==R.id.Itemcontacto){

                    Intent intent = new Intent(MainActivity.this, CustomListViewActivity.class);
                    startActivity(intent);
                                    return true;
                }

                return false;
            }

        });



    }

    @SuppressLint("WrongViewCast")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        if (id == R.id.nav_ins) {
            fm.beginTransaction().replace(R.id.idcontenido,new InstitucionFragment()).commit();

        } else if (id == R.id.nav_aut) {
            fm.beginTransaction().replace(R.id.idcontenido,new AutoridadesFragment()).commit();

        } else if (id == R.id.nav_proyect) {
            fm.beginTransaction().replace(R.id.idcontenido,new ProyectosFragment()).commit();

        } else if (id == R.id.nav_maestro) {
            fm.beginTransaction().replace(R.id.idcontenido,new ModalidadMaestroFragment()).commit();

        }else if (id == R.id.nav_csnaturales) {
            fm.beginTransaction().replace(R.id.idcontenido,new ModalidadMaestroFragment()).commit();

        }else if (id == R.id.nav_gestion) {
            fm.beginTransaction().replace(R.id.idcontenido,new ModalidadGestionFragment()).commit();

        }

        else if (id == R.id.nav_staff) {
            fm.beginTransaction().replace(R.id.idcontenido,new Staff_Fragment()).commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          switch (item.getItemId()){
         case R.id.action_settings:
             return true;
         case R.id.home:
            return true;
          }


        return super.onOptionsItemSelected(item);
    }


}
