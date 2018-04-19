package com.zakiadev.testakumikro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import junit.framework.Test;

/**
 * Created by sulistyarif on 19/04/18.
 */

public class TestUIActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout menu1, menu2, menu3, menu4, menu5, menu6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama_square);
        set1();
    }

    private void set1() {
        menu1 = (LinearLayout)findViewById(R.id.llmenu1);
        menu2 = (LinearLayout)findViewById(R.id.llmenu2);
        menu3 = (LinearLayout)findViewById(R.id.llmenu3);
        menu4 = (LinearLayout)findViewById(R.id.llmenu4);
        menu5 = (LinearLayout)findViewById(R.id.llmenu5);
        menu6 = (LinearLayout)findViewById(R.id.llmenu6);

        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);
        menu5.setOnClickListener(this);
        menu6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.llmenu1:{
                Intent intent = new Intent(TestUIActivity.this, JurnalKecActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu2:{
                Intent intent = new Intent(TestUIActivity.this, MenuLaporanAcvtivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu3:{
                Intent intent = new Intent(TestUIActivity.this, MenuPengaturanActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu4:{
                Intent intent = new Intent(TestUIActivity.this, MenuUtamaMateri.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu5:{
                Intent intent = new Intent(TestUIActivity.this, PetunjukActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu6:{
                Intent intent = new Intent(TestUIActivity.this, AboutAppsActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
