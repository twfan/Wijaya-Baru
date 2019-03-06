package e.taufan.customerapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class editBankActivity extends AppCompatActivity {

    Spinner spinBank;
    String[] items = new String[]{"BCA","MANDIRI","BNI","BTN","BUKOPIN","DANAMON"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bank);

        spinBank = findViewById(R.id.spin_bank);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinBank.setAdapter(adapter);

        getSupportActionBar().setTitle("Add Bank");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
