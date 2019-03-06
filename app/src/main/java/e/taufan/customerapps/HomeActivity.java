package e.taufan.customerapps;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import e.taufan.customerapps.Fragment.HomeFragment;
import e.taufan.customerapps.Fragment.TransactionFragment;
import e.taufan.customerapps.Fragment.PesanFragment;
import e.taufan.customerapps.Fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        loadFragment(new HomeFragment());
        getSupportActionBar().setElevation(0);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home:
                getSupportActionBar().setTitle("Awal");
                fragment = new HomeFragment();
                break;
            case R.id.pesan:
                getSupportActionBar().setTitle("Transaksi");
                fragment = new TransactionFragment();
                break;
            case R.id.inbox:
                getSupportActionBar().setTitle("Berita");
                fragment = new PesanFragment();
                break;
            case R.id.profile:
                getSupportActionBar().setTitle("Profil");
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
