package e.taufan.customerapps;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.InputStream;
import java.util.ArrayList;

public class CardViewItemAdapter extends  RecyclerView.Adapter<CardViewItemAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<Item> listItem;

    public CardViewItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder cardViewHolder, int i) {
        Item item = getListItem().get(i);
//        Picasso.get()
//                .load(item.getPhoto())
//                .placeholder(R.drawable.dummy300)
//                .error(R.drawable.error)
//                .into(cardViewHolder.imgPhoto);

        Glide.with(context).load(item.getPhoto()).apply(new RequestOptions().fitCenter()).into(cardViewHolder.imgPhoto);
        cardViewHolder.tvName.setText(item.getName());
//        cardViewHolder.tvPrice.setText(item.getPrice());

        cardViewHolder.btn_deskripsi.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
//                Intent openThree = new Intent(context,ItemDetailActivity.class);
//                context.startActivity(openThree);
                Intent moveWithDataIntent = new Intent(context, ItemDetailActivity.class);
                moveWithDataIntent.putExtra(ItemDetailActivity.EXTRA_NAME,getListItem().get(position).getPhoto());
                context.startActivity(moveWithDataIntent);
            }
        }));

        cardViewHolder.frame_item.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent moveWithDataIntent = new Intent(context, ItemDetailActivity.class);
                moveWithDataIntent.putExtra(ItemDetailActivity.EXTRA_NAME,getListItem().get(position).getPhoto());
                context.startActivity(moveWithDataIntent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListItem().size();
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgPhoto;
        Button btn_deskripsi;
        LinearLayout frame_item;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
//            tvPrice = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item);
            btn_deskripsi = itemView.findViewById(R.id.btn_deskripsi);
            frame_item = itemView.findViewById(R.id.frame_item);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
