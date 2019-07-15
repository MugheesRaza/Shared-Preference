package com.example.mughees.mplassignment;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MoviesList extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> data;
    private ArrayAdapter arrayAdapter;
    private int idPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewMain);

        data = new ArrayList<>();
        data.add("Game of Thrones season 1");
        data.add("Game of Thrones season 2");
        data.add("Game of Thrones season 3");
        data.add("Game of Thrones season 4");
        data.add("Game of Thrones season 5");
        data.add("Game of Thrones season 6");
        data.add("Game of Thrones season 7");
        data.add("Game of Thrones season 8");


        arrayAdapter = new ArrayAdapter(this,R.layout.activity_movies_listitem,R.id.listViewItem,data);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                idPosition = i;
                alertDialog(idPosition);
            }
        });
    }
    private void alertDialog(final int idPosition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setMessage("Are you sure")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data.remove(idPosition);
                        arrayAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
