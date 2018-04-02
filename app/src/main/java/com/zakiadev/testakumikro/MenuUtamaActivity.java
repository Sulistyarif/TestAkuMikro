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
import android.widget.ListView;
import android.widget.TextView;

import com.zakiadev.testakumikro.data.DataPerusahaan;
import com.zakiadev.testakumikro.db.DBAdapterMix;

/**
 * Created by Sulistyarif on 31/01/2018.
 */

public class MenuUtamaActivity extends AppCompatActivity {

    TextView tvNamaPerusahaan;
    ListView lvMenuUtama;
    EditText etAwalNamaPers;
    Button btAwalNamaPers;

    String[] menu = {"Jurnal", "Laporan", "Pengaturan", "Materi", "Petunjuk", "Tentang"};
    int[] icMenu = {R.drawable.menut1, R.drawable.menut2, R.drawable.menut3, R.drawable.menut4, R.drawable.menut5, R.drawable.menut6};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama_activity);

        tvNamaPerusahaan = (TextView)findViewById(R.id.tvNamaPerusahaan);

        CustomListAdapterMenuUtama adapter = new CustomListAdapterMenuUtama(this, menu, icMenu);
        lvMenuUtama = (ListView) findViewById(R.id.lvMenuUtama);
        lvMenuUtama.setAdapter(adapter);

        lvMenuUtama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MenuUtamaActivity.this, menu[i], Toast.LENGTH_SHORT).show();
                Log.i("YangDiklik", "Yang diklik : " + menu[i]);
                switch (i){
                    case 0 :{
                        Intent intent = new Intent(MenuUtamaActivity.this, JurnalKecActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 1:{
                        Intent intent = new Intent(MenuUtamaActivity.this, MenuLaporanAcvtivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 2:{
                        Intent intent = new Intent(MenuUtamaActivity.this, MenuPengaturanActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 3:{
//                        untuk menuju ke materi
                        Intent intent = new Intent(MenuUtamaActivity.this, MenuUtamaMateri.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:{
                        Intent intent = new Intent(MenuUtamaActivity.this, PetunjukActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        Intent intent = new Intent(MenuUtamaActivity.this, AboutAppsActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        DataPerusahaan dataPerusahaan = new DBAdapterMix(MenuUtamaActivity.this).selectDataPerusahaan();
        tvNamaPerusahaan.setText(dataPerusahaan.getNamaPers());
    }
}
