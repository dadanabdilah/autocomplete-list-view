package com.abdilahstudio.modul3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    AutoCompleteTextView ac;
    EditText lv;
    public String[] stringdatafak = {"Teknin Informatika", "Sistem Informasi", "Management Informatika D3", "Teknik Sipil", "Desan Komunikasi Visual"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LinearLayout linear = findViewById(R.id.LinearBackground);
        linear.setBackgroundColor(getResources().getColor(R.color.blue));
    }

    public void pilihprodi (View v) {
        lv = (EditText) findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Prodi Fakultas Ilmu Komputer");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        }).show();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    public void afterTextChanged(Editable s) { }
}