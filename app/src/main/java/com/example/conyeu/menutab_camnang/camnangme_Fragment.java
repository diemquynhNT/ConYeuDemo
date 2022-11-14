package com.example.conyeu.menutab_camnang;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.conyeu.DetailCamnang_Activity;
import com.example.conyeu.R;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.Camnang;
import com.example.conyeu.Adapter.Camnang_Adapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class camnangme_Fragment extends Fragment {


    View view;
    final String DATABASE_CN="CamnangDB.db";
    SQLiteDatabase database=null;
    String DB_PATH_SUFFIX = "/databases/";


    private RecyclerView mRecyclerView;
    private ArrayList<Camnang> Listcamnang;
    private Camnang_Adapter camnangAdapter;
    Camnang camnang;
    DBHelper dbHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cn_me, container, false);

        xulySaochep();
        initUi();



        return view;
    }

    private void xulySaochep() {
        File dbFile = view.getContext().getDatabasePath(DATABASE_CN);
        if (!dbFile.exists()) {
            try{
                copyDatabase(dbFile);
                Toast.makeText(view.getContext(), "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            } catch
            (Exception e)
            { Toast.makeText
                    (view.getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }

    }

    //Cach 2
    public void copyDatabase(File dbFile) {

        try {
            InputStream is = view.getContext().getAssets().open("CamnangDB.db");
            OutputStream os = new FileOutputStream(dbFile);

            byte[] buffer = new byte[1024];
            while (is.read(buffer) > 0) {
                os.write(buffer);
            }

            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void initUi()
    {
        dbHelper = new DBHelper(view.getContext());
        Listcamnang= new ArrayList<>();
//        dbHelper.insertCamnang(camnang);

        ArrayList<Camnang> data = dbHelper.getCamnang_me();
        Listcamnang.addAll(data);


//        if(camnang.getId())

        mRecyclerView=view.findViewById(R.id.rvDangmangthai);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //phan canh
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this.getContext(),DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        camnangAdapter=new Camnang_Adapter(Listcamnang, this.getContext(), new Camnang_Adapter.Listener() {
            @Override
            public void onClickListenerCamnang(Camnang camnang) {

                onClickDetailCamNang(camnang);
            }
        });

        mRecyclerView.setAdapter(camnangAdapter);







    }

    private void onClickDetailCamNang(Camnang camnang) {
        Intent intent=new Intent(view.getContext(), DetailCamnang_Activity.class);
        intent.putExtra("CamnangView", camnang);
        startActivity(intent);
    }

}