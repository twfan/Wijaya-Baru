package e.taufan.customerapps.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import e.taufan.customerapps.Object.Pesan;
import e.taufan.customerapps.R;

public class ListPesananAdapter extends RecyclerView.Adapter<ListPesananAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Pesan> listPesan;

        public ListPesananAdapter(ArrayList<Pesan> listPesan, Context context) {
        this.context = context;
        this.listPesan = listPesan;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_pesan, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
    categoryViewHolder.tv_item_name.setText(getListPesan().get(i).getID_TRANS());
    categoryViewHolder.tanggal.setText(getListPesan().get(i).getTANGGAL());
    }

    @Override
    public int getItemCount() {
        return listPesan.size();
    }

    public ArrayList<Pesan> getListPesan() {
        return listPesan;
    }

    public void setListPesan(ArrayList<Pesan> listPesan) {
        this.listPesan = listPesan;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_item_name;
        TextView tanggal;
        ImageView img_item_photo;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_item_name = itemView.findViewById(R.id.tv_item_name);
            tanggal = itemView.findViewById(R.id.tanggal);
            img_item_photo = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
