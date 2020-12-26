package com.ums.hitung;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class HitungUmur {
    protected static int tahunIni;
    protected int tahunLahir;
    int umur(){
        //tahun sekarang
        Calendar c = Calendar.getInstance();
        this.tahunIni = c.get(Calendar.YEAR);
        return tahunIni - tahunLahir;
    }

    public void setTahunLahir(int tahunLahir) {
        this.tahunLahir = tahunLahir;
    }
}
