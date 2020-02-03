package com.example.umpirebuddy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.service.autofill.OnClickAction;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnBall;
    Button btnStrike;
    Button btnReset;
    Button btnExit;

    TextView txtBall;
    TextView txtStrike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Button increments the balls
        btnBall = (Button)findViewById(R.id.buttonBall);
        txtBall = (TextView)findViewById(R.id.textViewBall);
        btnBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int ballCount = Integer.parseInt(txtBall.getText().toString());
              ballCount++;
                if (ballCount >= 4){
                    btnBall.setEnabled(false);
                }
              txtBall.setText(String.valueOf(ballCount));
            }
        });

        // Button increments the strikes
        btnStrike = (Button)findViewById(R.id.buttonStrike);
        txtStrike = (TextView)findViewById(R.id.textViewStrike);
        btnStrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int strikeCount = Integer.parseInt(txtStrike.getText().toString());
                strikeCount++;
                if (strikeCount >= 3){
                    btnStrike.setEnabled(false);
                }
                txtStrike.setText(String.valueOf(strikeCount));
            }
        });

        // Button resets balls and strikes
        btnReset = (Button)findViewById(R.id.buttonReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBall.setText("0");
                txtStrike.setText("0");
                btnBall.setEnabled(true);
                btnStrike.setEnabled(true);
            }
        });

        // Button exits application
        btnExit = (Button)findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

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
