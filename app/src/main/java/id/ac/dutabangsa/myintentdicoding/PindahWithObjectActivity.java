package id.ac.dutabangsa.myintentdicoding;

         import android.support.v7.app.AppCompatActivity;
         import android.os.Bundle;
         import android.widget.TextView;

         import butterknife.BindView;
         import butterknife.ButterKnife;

public class PindahWithObjectActivity extends AppCompatActivity {
    public static String EXTRA_ORANG = "extra_orang";
    @BindView(R.id.tv_penerima_object)
    TextView tvWithObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_with_object);
        ButterKnife.bind(this);
        Orang mOrang = getIntent().getParcelableExtra(EXTRA_ORANG);
        String seseorang = "nama: " + mOrang.getNama() + ", email: " + mOrang.getEmail() + ",umur: " + mOrang.getUmur() + " ,kota asal: " + mOrang.getKota();
        tvWithObject.setText(seseorang);

    }
}
