package com.webgump.youpicityappandroid;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.webgump.youpicityappandroid.account.SignIn;
import com.webgump.youpicityappandroid.home.Accueil;
import com.webgump.youpicityappandroid.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);


        final Button connexion = (Button) findViewById(R.id.SignIn);
        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(intent, bundle);
            }
        });

        final Button connexionFB = (Button) findViewById(R.id.ConnexionFB);
        connexionFB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
