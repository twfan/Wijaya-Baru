package e.taufan.customerapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class editNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);

        getSupportActionBar().setTitle("Full name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
