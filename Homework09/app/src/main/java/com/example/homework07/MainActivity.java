package com.example.homework07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavHostFragment navHostFragment;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    private MediaPlayer mp=new MediaPlayer();
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment =(NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        DrawerLayout drawerLayout = findViewById(R.id.drawLayout);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.homefragment)
                .setOpenableLayout(drawerLayout)
                .build();
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);

        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navView,navController);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }


    @Override
    public boolean onSupportNavigateUp(){
        return NavigationUI.navigateUp(navController,appBarConfiguration)||super.onSupportNavigateUp();
    }

}