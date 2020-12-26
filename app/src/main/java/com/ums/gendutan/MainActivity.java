package com.ums.gendutan;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SeekBar seekbarBerat;
    private TextView textBerat;
    private SeekBar seekbarTinggi;
    private TextView textTinggi;
    private TextView textLahir;
    private Button hitungBtn;
    private RadioGroup radioGroup;
    protected static String peringatan = "Lengkapi Data yang diminta dulu";

    private TextView tentang;
    protected int dataKelamin=5;
    protected int dataLahir;
    protected int dataBerat;
    protected int dataTinggi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ambil object dari gui
        Button btn_tgl = findViewById(R.id.buttontgl);
        textBerat = findViewById(R.id.textberatvalue);
        seekbarBerat = findViewById(R.id.seekBerat);
        seekbarTinggi = findViewById(R.id.seekTinggi);
        textTinggi = findViewById(R.id.textViewTinggi);
        textLahir = findViewById(R.id.textLahir);
        hitungBtn = findViewById(R.id.buttonHitung);
        tentang = findViewById(R.id.textViewTentang);
        //seekbar untuk berat badan
        seekbarBerat.setMax(200);
        seekbarBerat.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textBerat.setText(String.valueOf(progress)+" Kg");
                dataBerat = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        //seekbar untuk Tinggi badan
        seekbarTinggi.setMax(200);
        seekbarTinggi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textTinggi.setText(String.valueOf(progress)+" Cm");
                dataTinggi = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });


        //tombol untuk pilih tanggal
        btn_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTanggalDialog();

            }
        });

        //tombol tentang aplikasi
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(intent);

            }
        });
        //tombol hitung
        hitungBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dataKelamin!=5) {
                    Intent intent = new Intent(MainActivity.this, HasilActivity.class);
                    intent.putExtra("KELAMIN", String.valueOf(dataKelamin));
                    intent.putExtra("LAHIR", String.valueOf(dataLahir));
                    intent.putExtra("BERAT", String.valueOf(dataBerat));
                    intent.putExtra("TINGGI", String.valueOf(dataTinggi));
                    startActivity(intent);
                }else {
                    peringatan();
                }
            }
        });

        kelaminRadioButton();

    }

    public void kelaminRadioButton() {

        radioGroup = findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioLaki:
                        dataKelamin = 1;
                        break;
                    case R.id.radioCewek:
                        dataKelamin = 0;
                        break;
                }

            }
        });


    }


    public void showTanggalDialog(){
        /*
         Method untuk menampilkan tanggal menggunakan class datepicker dari android
         */
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int tahun, int bulan, int tanggal) {

                //mrmasukan tanggal ke return dateFormatter.format(newDate.getTime())
                textLahir.setText(String.valueOf(tanggal)+"/"+String.valueOf(bulan)+"/"+String.valueOf(tahun));
                //masukan tanggal ke variabel
                dataLahir=tahun;
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    void peringatan(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Lengkapi Data");
        alert.setMessage(peringatan);
        alert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

}