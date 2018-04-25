package com.zakiadev.testakumikro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zakiadev.testakumikro.data.DataPerusahaan;
import com.zakiadev.testakumikro.db.DBAdapterMix;

/**
 * Created by Sulistyarif on 31/01/2018.
 */

public class MenuUtamaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvNamaPerusahaan;
    TextView tvAlamatPerusahaan;
    LinearLayout menu1, menu2, menu3, menu4, menu5, menu6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama_square);

        tvNamaPerusahaan = (TextView)findViewById(R.id.tvNamaPerusahaanSquare);
        tvAlamatPerusahaan = (TextView)findViewById(R.id.tvAlamatPerusahaanSquare);

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
    protected void onResume() {
        super.onResume();
        DataPerusahaan dataPerusahaan = new DBAdapterMix(MenuUtamaActivity.this).selectDataPerusahaan();
        tvNamaPerusahaan.setText(dataPerusahaan.getNamaPers());
        tvAlamatPerusahaan.setText(dataPerusahaan.getAlamat());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.llmenu1:{
                Intent intent = new Intent(MenuUtamaActivity.this, JurnalKecActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu2:{
                Intent intent = new Intent(MenuUtamaActivity.this, MenuLaporanAcvtivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu3:{
                Intent intent = new Intent(MenuUtamaActivity.this, MenuUtamaMateri.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu4:{
                Intent intent = new Intent(MenuUtamaActivity.this, MenuPengaturanActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu5:{
                Intent intent = new Intent(MenuUtamaActivity.this, PetunjukActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.llmenu6:{
                Intent intent = new Intent(MenuUtamaActivity.this, AboutAppsActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
