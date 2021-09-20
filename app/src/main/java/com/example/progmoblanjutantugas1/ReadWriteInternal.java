package com.example.progmoblanjutantugas1;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadWriteInternal {
    static void TulisData(String filename, String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Kesalahan Menulis", "Penyimpanan file gagal: " + e.toString());
        }
    }

    static String BacaData(Context context,String filename) {
        String namafile = "";
        try {
            InputStream inputStream = context.openFileInput(filename);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                namafile = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("Kesalahan Membaca", "File tidak ditemukan." + e.toString());
        } catch (IOException e) {
            Log.e("Kesalahan Membaca", "Tidak bisa membuka file." + e.toString());
        }
        return namafile;
    }
}