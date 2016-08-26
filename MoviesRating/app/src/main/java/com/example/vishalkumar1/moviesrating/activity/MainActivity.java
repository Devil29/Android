package com.example.vishalkumar1.moviesrating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

import com.example.vishalkumar1.moviesrating.R;
import com.example.vishalkumar1.moviesrating.activity.fragment.MoviePageFragment;
import com.example.vishalkumar1.moviesrating.activity.fragment.NowPlayingMovieFragment;
import com.example.vishalkumar1.moviesrating.activity.fragment.PopoularMovieFragment;
import com.example.vishalkumar1.moviesrating.activity.fragment.TopRatedFragment;
import com.example.vishalkumar1.moviesrating.activity.fragment.UpcomingMovieFragment;
import com.example.vishalkumar1.moviesrating.model.Movie;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupFabButton();
        setupNavigationDrawer();
        setToolbarTItle("MoviesRating");

        fragmentManager = getSupportFragmentManager();
        Fragment fragment =new UpcomingMovieFragment();
        fragmentManager.beginTransaction().replace(R.id.container_main,fragment).commitAllowingStateLoss();

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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.upcoming) {
            setToolbarTItle("Upcoming");
            Fragment fragment =new UpcomingMovieFragment();
            fragmentManager.beginTransaction().replace(R.id.container_main,fragment).commitAllowingStateLoss();
        } else if (id == R.id.top_rated) {
            setToolbarTItle("TopRated");
            Fragment fragment =new TopRatedFragment();
            fragmentManager.beginTransaction().replace(R.id.container_main,fragment).commitAllowingStateLoss();
        } else if (id == R.id.popular) {
            setToolbarTItle("Popular");
            Fragment fragment =new PopoularMovieFragment();
            fragmentManager.beginTransaction().replace(R.id.container_main,fragment).commitAllowingStateLoss();
        } else if (id == R.id.now_playing) {
            setToolbarTItle("Now Playing");
            Fragment fragment =new NowPlayingMovieFragment();
            fragmentManager.beginTransaction().replace(R.id.container_main,fragment).commitAllowingStateLoss();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setToolbarTItle(String string){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(string);
    }

    private void setupFabButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setupNavigationDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void moviePage(Movie movie){
        Fragment fragment = new MoviePageFragment();
        Bundle args=new Bundle();
        args.putSerializable("Data", movie);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.container_main,fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
