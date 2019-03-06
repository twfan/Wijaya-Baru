package e.taufan.customerapps.Fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenu;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import e.taufan.customerapps.Item;
import e.taufan.customerapps.ItemActivity;
import e.taufan.customerapps.MenuActivity;
import e.taufan.customerapps.Object.Pesan;
import e.taufan.customerapps.R;
import io.github.yavski.fabspeeddial.FabSpeedDial;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<Item> list;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RippleView rippleView = (RippleView) view.findViewById(R.id.rip_galeri);
        FabSpeedDial fabSpeedDial = (FabSpeedDial) view.findViewById(R.id.fabspeed);

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "Banner " +position, Toast.LENGTH_SHORT).show();
            }
        });


        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.action_call){
                    String phone_number = "085732777009";
                    Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phone_number));
                    startActivity(dialPhoneIntent);
                }else if(menuItem.getItemId() == R.id.action_chat){
                    String contact = "+62 85732777009"; // use country code with your phone number
                    String url = "https://api.whatsapp.com/send?phone=" + contact;
                    try {
                        PackageManager pm = getContext().getPackageManager();
                        pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    } catch (PackageManager.NameNotFoundException e) {
                        Toast.makeText(getContext(), "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });

        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                startActivity(new Intent(getContext(), ItemActivity.class));
            }
        });
        return view;
    }
}
