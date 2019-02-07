package com.example.lab1umpirebuddy;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int mStrikeCount = 0;
    private int mballCount = 0;
    private int mTotalCount = 0;
    public Button ballBtn;
    public Button strikeBtn;
    public TextView strikeTx;
    public TextView ballTx;
    public TextView totalCountNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ballBtn = (Button) findViewById(R.id.ballButton);
        strikeBtn = (Button) findViewById(R.id.strikeButton);
        ballTx = (TextView) findViewById((R.id.ballCount));
        strikeTx = (TextView) findViewById(R.id.strikeCount);
        totalCountNumber = (TextView) findViewById(R.id.totalCountTx);


        strikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStrikeCount++;
                if (mStrikeCount == 3) {
                    mTotalCount++;
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Out!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mStrikeCount = 0;
                            mballCount = 0;
                            totalCountNumber.setText(Integer.toString(mTotalCount));
                            strikeTx.setText(Integer.toString(mStrikeCount));
                            ballTx.setText(Integer.toString(mballCount));
                        }
                    });
                    builder.show();
                }
                strikeTx.setText(Integer.toString(mStrikeCount));
            }
        });


        ballBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mballCount++;
                if (mballCount == 4) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Walk!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mballCount = 0;
                            mStrikeCount = 0;
                            ballTx.setText(Integer.toString(mballCount));
                            strikeTx.setText(Integer.toString(mStrikeCount));
                        }
                    });
                    builder.show();
                }
                ballTx.setText(Integer.toString(mballCount));

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.title1:
                mTotalCount=0;
                totalCountNumber.setText(Integer.toString(mTotalCount));
                break;

            case R.id.title2:
                openMain2Activity();
                break;
        }
        return true;
    }
    public void openMain2Activity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}


