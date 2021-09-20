package com.example.progmoblanjutantugas1;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class DataInternal extends AppCompatActivity {

    Button tambahfile;
    Button bukafile;
    Button simpanfile;
    EditText editContent;
    EditText editTitle;
    File path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tambahfile = (Button) findViewById(R.id.button_new);
        bukafile = (Button) findViewById(R.id.button_open);
        simpanfile = (Button) findViewById(R.id.button_save);
        editContent = (EditText) findViewById(R.id.edit_file);
        editTitle = (EditText) findViewById(R.id.edit_title);
        path = getFilesDir();

        tambahfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                filebaru();
            }
        });

        bukafile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                filebuka();
            }
        });

        simpanfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                filesimpan();
            }
        });
    }

    public void filebaru() {
        editTitle.setText("");
        editContent.setText("");
        Toast.makeText(this, "Membuat file baru", Toast.LENGTH_SHORT).show();
    }

    private void loadData(String title) {
        String text = ReadWriteInternal.BacaData(this, title);
        editTitle.setText(title);
        editContent.setText(text);
        Toast.makeText(this, "Membuka file " + title, Toast.LENGTH_SHORT).show();
    }

    public void filebuka() {
        final ArrayList<String> arrayList = new ArrayList<String>();
        for (String file : path.list()) {
            arrayList.add(file);
        }
        final CharSequence[] items = arrayList.toArray(new CharSequence[arrayList.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih file yang ingin dibuka.");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                loadData(items[item].toString());
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void filesimpan() {
        if (editTitle.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nama file belum diisi", Toast.LENGTH_SHORT).show();
        } else {
            String title = editTitle.getText().toString();
            String text = editContent.getText().toString();
            ReadWriteInternal.TulisData(title, text, this);
            Toast.makeText(this,
                    "Menyimpan file " + editTitle.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}