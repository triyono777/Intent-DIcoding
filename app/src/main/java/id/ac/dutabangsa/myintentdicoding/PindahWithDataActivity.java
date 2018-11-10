package id.ac.dutabangsa.myintentdicoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PindahWithDataActivity extends AppCompatActivity {

    public static String EXTRA_AGE = "extra_age";
    public static String EXTRA_NAME = "extra_name";
    @BindView(R.id.tv_penerima)
    TextView tvpenerima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_with_data);
        ButterKnife.bind(this);
        String nama = getIntent().getStringExtra(EXTRA_NAME);
        int umur = getIntent().getIntExtra(EXTRA_AGE,0);
        String textNamaUmur = "Name :" + nama +", umurmu : "+umur;
        tvpenerima.setText(textNamaUmur);
    }
}
