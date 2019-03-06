package e.taufan.customerapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class editNpwpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_npwp);

        getSupportActionBar().setTitle("Add Email");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
