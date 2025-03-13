package iut.dam.powerhome;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.ActionBarDrawerToggle;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;


import java.util.ArrayList;

public class HabitatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navNV;
    ActionBarDrawerToggle toggle;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitat);
        getRemoteHabitats();

        drawerLayout = findViewById(R.id.drawerlayout);

        navNV = findViewById(R.id.navigationview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_navigation_view, R.string.close_navigation_view);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fm = getSupportFragmentManager();
        navNV.setNavigationItemSelectedListener(this);
        Log.d("NAVIGATION", "setNavigationItemSelectedListener activé");

        navNV.getMenu().performIdentifierAction(R.id.navigationview, 0);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return toggle.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        Log.d("NAVIGATION", "Item clicked: " + item.getItemId());
        Fragment selectedFragment = null;

        if (item.getItemId() == R.id.Import) {
            selectedFragment = new ImportFragment();
            Log.d("NAVIGATION", "ImportFragment loaded");
        } else if (item.getItemId() == R.id.Gallery) {
            selectedFragment = new GalleryFragment();
            Log.d("NAVIGATION", "GalleryFragment loaded");
        } else if (item.getItemId() == R.id.Slideshow) {
            selectedFragment = new SlideshowFragment();
            Log.d("NAVIGATION", "SlideshowFragment loaded");
        } else if (item.getItemId() == R.id.Tools) {
            selectedFragment = new ToolsFragment();
            Log.d("NAVIGATION", "ToolsFragment loaded");
        } else if (item.getItemId() == R.id.Habitats) {
            selectedFragment = new HabitatFragment();
        }
        if (selectedFragment != null) {
            fm.beginTransaction().replace(R.id.containerFG, selectedFragment).commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    ProgressDialog pDialog;
    public void getRemoteHabitats() {
        String urlString = "http://10.0.2.2/powerhome_server/getHabitats.php";
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Getting list of habitats...");
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
        Ion.with(this)
                .load(urlString)
                .asString()
                .withResponse()
                .setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e,Response<String> response)
                {
                        pDialog.dismiss();
                        if(response == null)
                            Log.d(TAG, "No response from the server!!!");
                        else {
                            Log.d(TAG, "Voici les donnes: "+response.getResult());
                        }
                    }
                });
    }

}
