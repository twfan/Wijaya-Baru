package e.taufan.customerapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    private RecyclerView rv_item;
    private ArrayList<Item> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        rv_item = findViewById(R.id.rv_item);
        rv_item.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(ItemData.getListData());

        showCardViewData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void showCardViewData() {

        rv_item.setLayoutManager(new LinearLayoutManager(this));
        CardViewItemAdapter cardViewItemAdapter = new CardViewItemAdapter(this);
        cardViewItemAdapter.setListItem(list);
        rv_item.setAdapter(cardViewItemAdapter);
    }
}
