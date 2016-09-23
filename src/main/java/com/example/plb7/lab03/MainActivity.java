/** Paige Brinks, plb7
 *
 *  9/23/2016
 *  Lab03
 *  Build a simple password-protected image using
 */


package com.example.plb7.lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // instance variables
    private FrameLayout pLayout;
    private EditText passwordField;
    private TextView invalidtext;
    private ImageView nougat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize vars
        pLayout = (FrameLayout) findViewById(R.id.protectedLayout);
        nougat = (ImageView) findViewById(R.id.nougat);
        passwordField = (EditText) findViewById(R.id.passwordField);
        invalidtext = (TextView) findViewById(R.id.invalidtext);

        // set visibility of image and text to invisible
        nougat.setVisibility(View.INVISIBLE);
        invalidtext.setVisibility(View.INVISIBLE);

        /** setOnEditorActionListener
         *  when the user enters in a password and hits enter it will:
         *      show nougat image if password is correct
         *      show "Incorrect Password" if password is incorrect
         */
        passwordField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String passCode = passwordField.getText().toString();

                // check that password is correct,
                // if so, display the nougat image
                if (passCode.equals("paige")) {
                    invalidtext.setVisibility(View.GONE);
                    nougat.setVisibility(View.VISIBLE);
                    return true;
                }
                // else, display the "Incorrect password" message
                else {
                    nougat.setVisibility(View.GONE);
                    invalidtext.setVisibility(View.VISIBLE);
                }

                return false;
            }
        });

    }

}
