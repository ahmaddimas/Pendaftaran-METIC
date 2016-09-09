package id.sch.smktelkom_mlg.tugas01.xirpl4001.pendaftaranmetic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    RadioGroup rgKelas;
    Spinner spKelas;
    TextView tvHasil, tvD, tvKelas;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        spKelas = (Spinner) findViewById(R.id.spinnerKLS);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvD = (TextView) findViewById(R.id.textViewDD);
        tvKelas = (TextView) findViewById(R.id.textViewKelas);
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupK);
        bOK = (Button) findViewById(R.id.buttonD);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private boolean isValid() {
        boolean valid = true;
        String kelas = null;
        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama wajib diisi");
            return false;
        } else {
            etNama.setError(null);

            if (rgKelas.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgKelas.getCheckedRadioButtonId());
                kelas = rb.getText().toString();

                tvD.setText("Data Diri Anda");
                tvHasil.setText("Nama               : " + nama + "\nKelas               : " + spKelas.getSelectedItem().toString() + "\nKelas di METIC : " + kelas);
            } else if (kelas == null) {
                tvKelas.setText("Kelas Wajib diisi");
            }

        }

        return valid;
    }

    private void doClick() {
        if (isValid()) ;
    }
}
