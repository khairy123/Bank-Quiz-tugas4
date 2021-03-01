package com.example.bankquis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
             "1. hasil dari 285:(-19)x6",
             "2. Pecahan berikut yang senilai dengan 16/40 adalah",
             "3. Bentuk desimal dari 17/20 adalah",
             "4. Ilmu pengetahuan tentang kuantitas, struktur, ruang dan perubahan adalah definisi dari ilmu",

    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
              "-19", "-20", "-21", "-22 ",
              "16/40:8=3/4", "16/40:8=3/5", "16/40:8=3/6", "16/40:8=3/7",
              "17/20x5=85/100=0,85", "17/20x5=90/100=0,90", "17/20x5=70/100=0,70", "17/20x5=50/100=0,50",
              "Sejarah", "Matematika", "Pengetahuan Sosial", "Bahasa Indonesia",

    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
             "-19",
             "16/40:8=3/5",
             "17/20x5=85/100=0,85",
             " Matematika",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis3.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab!",Toast.LENGTH_LONG).show();
        }
    }
}