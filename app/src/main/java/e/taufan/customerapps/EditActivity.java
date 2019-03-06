package e.taufan.customerapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvChangeName;
    TextView tvChangeEmail;
    TextView tvChangeAddress;
    TextView tvChangeNpwp;
    TextView tvChangeBank;
    CircleImageView cimgPhoto;

    private static final int IMAGE_REQUEST_CODE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvChangeName = findViewById(R.id.tv_change_name);
        tvChangeName.setOnClickListener(this);

        tvChangeEmail = findViewById(R.id.tv_change_email);
        tvChangeEmail.setOnClickListener(this);

        tvChangeAddress = findViewById(R.id.tv_change_address);
        tvChangeAddress.setOnClickListener(this);

        tvChangeNpwp = findViewById(R.id.tv_change_npwp);
        tvChangeNpwp.setOnClickListener(this);

        tvChangeBank = findViewById(R.id.tv_change_bank);
        tvChangeBank.setOnClickListener(this);

        cimgPhoto = findViewById(R.id.cimg_profil);
        cimgPhoto.setOnClickListener(this);

        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    //tambahin class object person buat pindah" data
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cimg_profil:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), IMAGE_REQUEST_CODE);
                break;
            case R.id.tv_change_name:
                Intent moveIntentChangeName = new Intent(EditActivity.this, editNameActivity.class);
                startActivity(moveIntentChangeName);
                break;
            case R.id.tv_change_email:
                Intent moveIntentChangeEmail = new Intent(EditActivity.this, editEmailActivity.class);
                startActivity(moveIntentChangeEmail);
                break;
            case R.id.tv_change_address:
                Intent moveIntentChangeAddress = new Intent(EditActivity.this, editAddressActivity.class);
                startActivity(moveIntentChangeAddress);
                break;
            case R.id.tv_change_npwp:
                Intent moveIntentChangeNpwp = new Intent(EditActivity.this, editNpwpActivity.class);
                startActivity(moveIntentChangeNpwp);
                break;
            case R.id.tv_change_bank:
                Intent moveIntentChangeBank = new Intent(EditActivity.this, editBankActivity.class);
                startActivity(moveIntentChangeBank);
                break;
        }
    }
}
