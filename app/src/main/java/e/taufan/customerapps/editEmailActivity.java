package e.taufan.customerapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class editEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        getSupportActionBar().setTitle("Add Email");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
