package id.ac.dutabangsa.myintentdicoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_pndh_activity)
    Button btnpndahaktvt;
    @BindView(R.id.btn_pndh_activity_dgn_data)
    Button btnpndahwithdata;
    @BindView(R.id.btn_pndh_activity_dgn_objek)
    Button btnpndahwithobjek;
    @BindView(R.id.btn_dialnumber)
    Button btnDialNumb;
    @BindView(R.id.btn_pindah_aktvy_untuk_result)
    Button btnforHasil;
    @BindView(R.id.tv_hasil)
    TextView tvHasil;
    private int REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnpndahaktvt.setOnClickListener(this);
        btnpndahwithdata.setOnClickListener(this);
        btnpndahwithobjek.setOnClickListener(this);
        btnDialNumb.setOnClickListener(this);
        btnforHasil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pndh_activity:
                Intent pindahIntent = new Intent(MainActivity.this, PindahActivity.class);
                startActivity(pindahIntent);
                break;
            case R.id.btn_pndh_activity_dgn_data:
                Intent pindahWithData = new Intent(MainActivity.this, PindahWithDataActivity.class);
                pindahWithData.putExtra(PindahWithDataActivity.EXTRA_NAME, "mantan anak dicoding");
                pindahWithData.putExtra(PindahWithDataActivity.EXTRA_AGE, 29);
                startActivity(pindahWithData);
                break;
            case R.id.btn_pndh_activity_dgn_objek:
                Orang iniOrang = new Orang();
                iniOrang.setNama("triyono");
                iniOrang.setEmail("triyono@gmail.com");
                iniOrang.setKota("surakarta");
                iniOrang.setUmur(29);
                Intent pndahwithobject = new Intent(MainActivity.this, PindahWithObjectActivity.class);
                pndahwithobject.putExtra(PindahWithObjectActivity.EXTRA_ORANG, iniOrang);
                startActivity(pndahwithobject);
                break;
            case R.id.btn_dialnumber:
                String nomortelepon = "085795054327";
                Intent notelpIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+nomortelepon));
                startActivity(notelpIntent);
                break;
            case R.id.btn_pindah_aktvy_untuk_result:
                Intent pndahforHasil = new Intent(MainActivity.this, PindahForHasilActivity.class);
                startActivityForResult(pndahforHasil,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int hasilCode, Intent datanilai) {
        super.onActivityResult(requestCode,hasilCode, datanilai);
        if (requestCode== REQUEST_CODE) {
            if (hasilCode== PindahForHasilActivity.HASIL_CODE) {
                int nilaiterpilih = datanilai.getIntExtra(PindahForHasilActivity.EXTRA_PILIHAN_NILAI, 0);
                tvHasil.setText("hasil : " + nilaiterpilih);
            }
        }
    }
}


