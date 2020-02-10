package com.example.umpirebuddy;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.service.autofill.OnClickAction;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnBall;
    Button btnStrike;
    Button btnReset;
    Button btnExit;
    Button btnAbout;

    TextView txtBall;
    TextView txtStrike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Button increments the balls
        btnBall = findViewById(R.id.buttonBall);
        txtBall = findViewById(R.id.textViewBall);
        btnBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int ballCount = Integer.parseInt(txtBall.getText().toString());
              ballCount++;
                if (ballCount >= 4){
                    btnBall.setEnabled(false);
                    btnStrike.setEnabled(false);
                    dialogPrompt("Walk!");
                }
              txtBall.setText(String.valueOf(ballCount));
            }
        });

        // Button increments the strikes
        btnStrike = findViewById(R.id.buttonStrike);
        txtStrike = findViewById(R.id.textViewStrike);
        btnStrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int strikeCount = Integer.parseInt(txtStrike.getText().toString());
                strikeCount++;
                if (strikeCount >= 3){
                    btnBall.setEnabled(false);
                    btnStrike.setEnabled(false);
                    dialogPrompt("Out!");
                }
                txtStrike.setText(String.valueOf(strikeCount));
            }
        });

        // Button resets balls and strikes
        btnReset = findViewById(R.id.buttonReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBall.setText("0");
                txtStrike.setText("0");
                btnBall.setEnabled(true);
                btnStrike.setEnabled(true);
            }
        });

        // Button takes you to About window
        btnAbout = findViewById(R.id.buttonAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPrompt("Umpire Buddy V 2.0 by Ashish Sharma");
            }
        });

        // Button exits application
        btnExit = findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    public void dialogPrompt(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
