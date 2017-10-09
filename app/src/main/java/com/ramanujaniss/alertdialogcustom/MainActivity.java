package com.ramanujaniss.alertdialogcustom;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showdialog(View view) {

        showcustomdialog();
    }

    private void showcustomdialog() {



        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialoguebox, null);
        Button btn_ratenow = (Button) mView.findViewById(R.id.ratenow);
        Button btn_later = (Button) mView.findViewById(R.id.later);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.setCancelable(false);
        dialog.show();

        btn_ratenow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Toast.makeText(Trimmer1Activity.this, "rate now", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Uri uri = Uri.parse("market://details?id=com.satman.sampathirao");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=com.satman.sampathirao")));
                }


            }



        });


        btn_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "OK. Thank You", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });







    }
}
