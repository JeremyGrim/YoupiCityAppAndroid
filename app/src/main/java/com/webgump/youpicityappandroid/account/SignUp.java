package com.webgump.youpicityappandroid.account;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.webgump.youpicityappandroid.R;
import com.webgump.youpicityappandroid.home.Accueil;

/**
 * Created by Administrateur on 06/09/2017.
 */

public class SignUp extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);
        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        final Button connexion = (Button) findViewById(R.id.SignUp);
        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignUp2.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SignUp.this).toBundle();
                startActivity(intent, bundle);
            }
        });



    }


}