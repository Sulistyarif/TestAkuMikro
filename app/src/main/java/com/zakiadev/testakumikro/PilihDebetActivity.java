package com.zakiadev.testakumikro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.zakiadev.testakumikro.tablehelper.TableHelperDataAkun;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.model.TableColumnDpWidthModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by Sulistyarif on 06/02/2018.
 */

public class PilihDebetActivity extends AppCompatActivity {

    FloatingActionButton fab;
    TableView<String[]> tableView;
    TableHelperDataAkun tableHelperDataAkun;
    int pilihanTrans, indexSumber;
    TextView tvJudul;
    float mLastMotionY;
    float mLastMotionX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jurnal_kecil_activity);

        tvJudul = (TextView)findViewById(R.id.tvJudul);
        tvJudul.setText("Pilih Akun Debet");

        fab = (FloatingActionButton)findViewById(R.id.btnAddJurnal);
        fab.setVisibility(View.GONE);

        pilihanTrans = getIntent().getIntExtra("pilihan", 99);
        indexSumber = getIntent().getIntExtra("sumber",0);
        Log.i("indexDebt", String.valueOf(indexSumber));

        tableHelperDataAkun = new TableHelperDataAkun(this);
        tableView = (TableView<String[]>)findViewById(R.id.tvKecJurnal);
//        tableView.setColumnCount(2);
        tableView.setHeaderBackgroundColor(Color.parseColor("#3498db"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableHelperDataAkun.getColHeader()));

        TableColumnDpWidthModel columnModel = new TableColumnDpWidthModel(PilihDebetActivity.this, 2, 200);
        columnModel.setColumnWidth(0, 105);
        columnModel.setColumnWidth(1, 300);
        tableView.setColumnModel(columnModel);

        switch (pilihanTrans){
            case 1:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,1)));
                break;
            }
            case 2:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,1)));
                break;
            }
            case 3:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,1,5,6,8,9, 10)));
                break;
            }
            case 4:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,2,3)));
                break;
            }
            case 5:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(7,8)));
                break;
            }
            case 6:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(9)));
                break;
            }
            case 7:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,1 ,2,3,7,8)));
                break;
            }
            case 8:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,2,7,8)));
                break;
            }
            case 9:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(2,6,5,0,10)));
                break;
            }
            case 99:{
                tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelperDataAkun.getDataPil(0,1,7,8,9)));
                break;
            }
        }

//        ketika dipilih itemnya, lalu akan kembali ke activity sebelumnya dengan melakukan passing data akun yang dipilih
        tableView.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
                Intent intent = new Intent();
                intent.putExtra("index", indexSumber);
                intent.putExtra("kodeDebet", clickedData[0]);
                intent.putExtra("namaDebet", clickedData[1]);
                intent.putExtra("jenisDebet", clickedData[2]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                tableView.requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                if (mLastMotionX != 0 && mLastMotionY != 0 && Math.abs(mLastMotionX - ev.getRawX()) > Math.abs(mLastMotionY - ev.getRawY())) {
                    tableView.requestDisallowInterceptTouchEvent(false);
                } else {
                    tableView.requestDisallowInterceptTouchEvent(true);
                }
                mLastMotionX = ev.getRawX();
                mLastMotionY = ev.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                tableView.requestDisallowInterceptTouchEvent(true);
                break;
        }

        return super.dispatchTouchEvent(ev);

    }
}