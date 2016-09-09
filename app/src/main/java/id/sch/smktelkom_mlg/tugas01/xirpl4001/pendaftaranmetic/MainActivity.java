package id.sch.smktelkom_mlg.tugas01.xirpl4001.pendaftaranmetic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    RadioGroup rgKelas;
    Spinner spKelas;
    TextView tvHasil, tvD, tvKelas;
    CheckBox cb, cbW, cbD, cbDG, cbJ, cbVE;
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
        cb = (CheckBox) findViewById(R.id.checkBox1);
        cbW = (CheckBox) findViewById(R.id.checkBoxW);
        cbD = (CheckBox) findViewById(R.id.checkBoxD);
        cbDG = (CheckBox) findViewById(R.id.checkBoxDG);
        cbJ = (CheckBox) findViewById(R.id.checkBoxJ);
        cbVE = (CheckBox) findViewById(R.id.checkBoxVE);
        bOK = (Button) findViewById(R.id.buttonD);

        cb.setOnCheckedChangeListener(this);

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
        String minat = "Kelas yang diminati :\n";
        int startlen = minat.length();
        String nama = etNama.getText().toString();
        StringBuilder hasil = new StringBuilder();

        if (nama.isEmpty()) {
            etNama.setError("Nama wajib diisi");
            etNama.requestFocus();
            return false;
        } else if (rgKelas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgKelas.getCheckedRadioButtonId());
            kelas = rb.getText().toString();
        }

        if (kelas == null) {
            tvKelas.setText("Kelas Wajib diisi");
            return false;
        } else {
            etNama.setError(null);
            etNama.clearFocus();
            tvD.setVisibility(View.VISIBLE);
            tvHasil.setVisibility(View.VISIBLE);
            tvD.setText("Data Diri Anda");
            hasil.append("Nama                      : ");
            hasil.append(nama);
            hasil.append("\nKelas                       : ");
            hasil.append(spKelas.getSelectedItem().toString());
            hasil.append("\nKelas di METIC      : ");
            hasil.append(kelas);
            hasil.append("\n");

            if (cbW.isChecked()) minat += cbW.getText() + "\n";
            if (cbD.isChecked()) minat += cbD.getText() + "\n";
            if (cbDG.isChecked()) minat += cbDG.getText() + "\n";
            if (cbJ.isChecked()) minat += cbJ.getText() + "\n";
            if (cbVE.isChecked()) minat += cbVE.getText() + "\n";
            if (minat.length() == startlen) minat += "Tidak ada pilihan";

            hasil.append(minat);
            tvHasil.setText(hasil);
        }

        return valid;
    }

    private void doClick() {
        if (isValid()) ;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (cb.isChecked() == false) {
            bOK.setVisibility(View.GONE);
        } else {
            bOK.setVisibility(View.VISIBLE);
        }
    }
}
