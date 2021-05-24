package com.spal.sajibpal.mathformula;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Home extends AppCompatActivity {

    CardView algrabaview, calculasview, probalityview, geomeotryview, trigonalview, othereview;
    AdView mAdView;
    InterstitialAd minterstialad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, "ca-app-pub-6756845076909977~3734530338");//app id
        interstitialAdshow();


        algrabaview = (CardView) findViewById(R.id.algebraid);
        calculasview = (CardView) findViewById(R.id.calculasid);
        probalityview = (CardView) findViewById(R.id.probalityid);
        geomeotryview = (CardView) findViewById(R.id.geomotryid);
        trigonalview = (CardView) findViewById(R.id.trigonalid);
        othereview = (CardView) findViewById(R.id.otherid);

        algrabaview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(Home.this, MathList.class);
                            intent.putExtra("optionmenu", "algebra");
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);
                        }
                    });

                } else {

                    startActivity(new Intent(Home.this, MathList.class).putExtra("optionmenu", "algebra"));
                }

            }
        });

        calculasview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for Member List

                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(Home.this, MathList.class);
                            intent.putExtra("optionmenu", "calculas");
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);
                        }
                    });

                } else {

                    startActivity(new Intent(Home.this, MathList.class).putExtra("optionmenu", "calculas"));
                }

            }
        });

        probalityview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //for Padma

                startActivity(new Intent(Home.this, Slide.class).putExtra("title", "probality"));
            }
        });
        geomeotryview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for coaching

                startActivity(new Intent(Home.this, Slide.class).putExtra("title", "geometry"));
            }
        });
        trigonalview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for panelbani

                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(Home.this, Slide.class);
                            intent.putExtra("title", "trigonal");
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);
                        }
                    });

                } else {

                    startActivity(new Intent(Home.this, Slide.class).putExtra("title", "trigonal"));
                }

            }
        });
        othereview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for notice

                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(Home.this, MathList.class);
                            intent.putExtra("optionmenu", "other");
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);
                        }
                    });

                } else {

                    startActivity(new Intent(Home.this, MathList.class).putExtra("optionmenu", "other"));
                }

            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.feadback) {

            startActivity(new Intent(Home.this, Mail.class).putExtra("mail", "sajib"));
        }
        if (id == R.id.about) {

            startActivity(new Intent(Home.this, DeveloperProfile.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void interstitialAdshow() {

        minterstialad = new InterstitialAd(this);
        minterstialad.setAdUnitId("ca-app-pub-6756845076909977/3671005050");// InterstitialAdd id
        minterstialad.loadAd(new AdRequest.Builder().build());
    }

}