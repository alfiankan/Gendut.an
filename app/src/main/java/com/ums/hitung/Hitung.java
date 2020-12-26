package com.ums.hitung;

public class Hitung extends IndexMasaTubuh{

    public Hitung(int kelamin, int tglLahir, int BeratBadan, int TinggiBadan){
        this.kelamin = kelamin;
        this.tglLahir = tglLahir;
        this.BeratBadan = BeratBadan;
        this.TinggiBadan = TinggiBadan;

    }

    public double Hitung(){
        double tinggi = (double) TinggiBadan/100;
        this.kuadrat = tinggi*tinggi;
        double hasil = (double)BeratBadan/kuadrat;
        this.hasilHitung=hasil;
        return hasil;
    }

    public String hasilImt(){
        return this.statusBB();
    }

    public int getUmur(){
        HitungUmur umur = new HitungUmur();
        umur.setTahunLahir(this.tglLahir);
        return umur.umur();
    }

    public int getSaran(){
        return (int)this.getSaranBB();
    }


    public int getBeratBadan() {

        return this.BeratBadan;
    }

    public String getKelamin() {
        String kelamin="-";
        if(this.kelamin==1){
            kelamin="Laki - Laki";
        }else {
            kelamin = "Perempuan";
        }
        return kelamin;
    }

    public int getTinggiBadan() {

        return this.TinggiBadan;
    }
}
