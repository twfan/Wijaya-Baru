package e.taufan.customerapps;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class ItemDetailActivity extends AppCompatActivity {

    Button btn_kirimpesan;
    TextView persentase;
    ImageView img_photo;

    public static final String EXTRA_NAME = "extra_photo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);



        String photo = getIntent().getStringExtra(EXTRA_NAME);



//        Glide.with(this).load("http://i.imgur.com/DvpvklR.png").into(imgPhoto);


//        new DownLoadImageTask(image).execute(photo);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btn_kirimpesan = findViewById(R.id.btnKirimPesan);
        img_photo = findViewById(R.id.img_photo);
        persentase = findViewById(R.id.persentase);


        Picasso.get()
                .load(getIntent().getStringExtra(EXTRA_NAME))
                .placeholder(R.drawable.dummy300)
                .error(R.drawable.error)
                .into(img_photo);

        Random rand = new Random();

        int n = rand.nextInt(100) + 1;

        persentase.setText(n+"%");


    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }
}
