package com.virtualstudios.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager(){
        ViewPager2 moviesViewPager = findViewById(R.id.moviesViewPager);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(((page, position) -> {
            float r = 1- Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        }));
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }

    private List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();

        Movie passengers = new Movie();
        passengers.poster = R.drawable.passengers;
        passengers.name = "Passengers";
        passengers.category = "Science Fiction";
        passengers.releaseDate = "December 22, 2016";
        passengers.rating = 4.6f;
        movies.add(passengers);

        Movie theTomorrowWar = new Movie();
        theTomorrowWar.poster = R.drawable.the_tomorrow_war;
        theTomorrowWar.name = "The Tomorrow War";
        theTomorrowWar.category = "Science Fiction";
        theTomorrowWar.releaseDate = "December 14, 2016";
        theTomorrowWar.rating = 4.8f;
        movies.add(theTomorrowWar);

        Movie annihilation = new Movie();
        annihilation.poster = R.drawable.annihilation;
        annihilation.name = "Annihilation";
        annihilation.category = "Science Fiction";
        annihilation.releaseDate = "February 13, 2018";
        annihilation.rating = 3.5f;
        movies.add(annihilation);

        Movie theMartin = new Movie();
        theMartin.poster = R.drawable.annihilation;
        theMartin.name = "The Martin";
        theMartin.category = "Science Fiction";
        theMartin.releaseDate = "October 02, 2015";
        theMartin.rating = 5f;
        movies.add(theMartin);

        return movies;
    }
}