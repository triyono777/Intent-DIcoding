package id.ac.dutabangsa.myintentdicoding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PindahForHasilActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.rg_nomor)
    RadioGroup rgNomor;
    @BindView(R.id.btn_pilih)
    Button btnPlih;

    public static String EXTRA_PILIHAN_NILAI = "extra_pilihan_nilai";
    public static int HASIL_CODE = 110;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_for_hasil);
        ButterKnife.bind(this);
        btnPlih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_pilih) {
            if (rgNomor.getCheckedRadioButtonId() != 0) {
                int nilai = 0;
                switch (rgNomor.getCheckedRadioButtonId()) {
                    case R.id.rb_50:
                        nilai = 50;
                        break;
                    case R.id.rb_100:
                        nilai = 100;
                        break;
                    case R.id.rb_150:
                        nilai = 150;
                        break;
                }
                Intent hasilIntent = new Intent();
                hasilIntent.putExtra(EXTRA_PILIHAN_NILAI, nilai);
                setResult(HASIL_CODE,hasilIntent);
                finish();
            }
        }
    }
}
