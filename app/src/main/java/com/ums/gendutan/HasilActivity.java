package com.ums.gendutan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.ums.hitung.Hitung;
public class HasilActivity extends AppCompatActivity {

    protected TextView hasilnya;
    protected ImageView imghasil;
    protected TextView wejangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        hasilnya = findViewById(R.id.textViewhasilnya);
        imghasil = findViewById(R.id.imageViewHasil);
        wejangan = findViewById(R.id.textViewWejangan);
        int kelamin = Integer.parseInt(getIntent().getStringExtra("KELAMIN"));
        int lahir = Integer.parseInt(getIntent().getStringExtra("LAHIR"));
        int berat = Integer.parseInt(getIntent().getStringExtra("BERAT"));
        int tinggi = Integer.parseInt(getIntent().getStringExtra("TINGGI"));

        hitung(kelamin,lahir,berat,tinggi);

    }


    protected void hitung(int kelamin,int lahir,int berat,int tinggi){
        Hitung htg = new Hitung(kelamin,lahir,berat,tinggi);
        String imt = String.valueOf(htg.Hitung());
        String statusImt = htg.hasilImt();
        hasilnya.setText("Kamu "+statusImt);
        //tentukan gambar => set gambar
        switch (statusImt){
            case "Kurus":
                imghasil.setImageResource(R.drawable.kurang);
                break;
            case "Ideal":
                imghasil.setImageResource(R.drawable.pass);
                break;
            case "Kegemukan":
                imghasil.setImageResource(R.drawable.lebih);
                break;
            case "Obesitas":
                imghasil.setImageResource(R.drawable.lebih);
                break;
        }

        //buat saran untuk mencapai berat badan ideal
        if(htg.getSaran()>0){
            //menambah berat
            wejangan.setText("Hai Umur kamu " +htg.getUmur()+" Berat Badan Kamu "+htg.getBeratBadan()+" Kg Tinggi Kamu " +htg.getTinggiBadan()+" cm \nSebaiknya Kamu Menambah Berat Badan Sebanyak "+String.valueOf(htg.getSaran())+" Kg");
        }else if(htg.getSaran()<0){
            //mengurangi berat
            wejangan.setText("Hai Umur kamu " +htg.getUmur()+" Berat Badan Kamu "+htg.getBeratBadan()+" Kg Tinggi Kamu " +htg.getTinggiBadan()+" cm \nSebaiknya Kamu Mengurangi Berat Badan Sebanyak "+String.valueOf(Math.abs(htg.getSaran()))+" Kg");
        }else{
            //mengurangi berat
            wejangan.setText("Hai Umur kamu " +htg.getUmur()+" Berat Badan Kamu "+htg.getBeratBadan()+" Kg Tinggi Kamu " +htg.getTinggiBadan()+" cm Pertahankan Karena Kamu Ideal :)");
        }


    }
}