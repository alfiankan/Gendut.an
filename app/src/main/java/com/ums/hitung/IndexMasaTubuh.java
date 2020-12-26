package com.ums.hitung;

public class IndexMasaTubuh {
    protected int kelamin;
    protected int tglLahir;
    protected int BeratBadan;
    protected int TinggiBadan;
    protected double hasilHitung;
    protected double kuadrat;
    protected String statusBB(){
        String hasil = "";
        if(kelamin==1){
            //untuk laki laki
            if(hasilHitung<18){
                //Kurus
                hasil = "Kurus";
            }else if(hasilHitung>=18 && hasilHitung<=25){
                //Normal
                hasil = "Ideal";
            }else if(hasilHitung>=25 && hasilHitung<=27) {
                //Kegemukan
                hasil = "Kegemukan";
            }else if(hasilHitung>27){
                //obesitas
                hasil = "Obesitas";
            }
        }else{
            //untuk perempuan
            if(hasilHitung<17){
                //Kurus
                hasil = "Kurus";
            }else if(hasilHitung>=17 && hasilHitung<=23){
                //Normal
                hasil = "Ideal";
            }else if(hasilHitung>=23 && hasilHitung<=27) {
                //Kegemukan
                hasil = "Kegemukan";
            }else if(hasilHitung>27){
                //obesitas
                hasil = "Obesitas";
            }
        }
        return hasil;
    }

    protected double getSaranBB(){
        double rekomendasi=0.0;
        if(kelamin==1){
            //laki laki
            if(hasilHitung<18){
                //menambah berat badan
                //cari berat badan dengan hasil sekarang
                double beratSekarang = hasilHitung*kuadrat;
                //cari berat badan dengan hasil ideal
                double beratIdeal = 21*kuadrat;
                rekomendasi = beratIdeal-beratSekarang;
            }else if(hasilHitung>25){
                //mengurangi berat badan
                //cari berat badan dengan hasil sekarang
                double beratSekarang = hasilHitung*kuadrat;
                //cari berat badan dengan hasil ideal
                double beratIdeal = 21*kuadrat;
                rekomendasi = beratIdeal-beratSekarang;
            }
        }else {
            //perempuan
            if(hasilHitung<17){
                //menambah berat badan
                //cari berat badan dengan hasil sekarang
                double beratSekarang = hasilHitung*kuadrat;
                //cari berat badan dengan hasil ideal
                double beratIdeal = 21*kuadrat;
                rekomendasi = beratIdeal-beratSekarang;
            }else if(hasilHitung>23){
                //mengurangi berat badan
                //cari berat badan dengan hasil sekarang
                double beratSekarang = hasilHitung*kuadrat;
                //cari berat badan dengan hasil ideal
                double beratIdeal = 21*kuadrat;
                rekomendasi = beratIdeal-beratSekarang;
            }
        }
        return rekomendasi;
    }

}
