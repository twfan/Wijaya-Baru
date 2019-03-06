package e.taufan.customerapps;

import android.media.Image;

import java.util.ArrayList;

public class ItemData {

    public static String[][] data = new String[][]{
            {"Dump", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/Bak-Besi.jpg"},
            {"Ekor Trailer", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/Ekor-Trailer.jpg"},
            {"Lowbed", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/Lowbed.jpg"},
            {"Lowbed", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/Lowbed1.jpg"},
            {"Bak", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/Bak.jpg"},
            {"Ekor Trailer 20 2 Axle", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/ekor-trailer-20-2-axle-1.jpg"},
            {"Tangki 3", "670000000", "https://www.wijayabaru.co.id/wp-content/uploads/2016/06/tangki3.png"}
    };


    public static ArrayList<Item> getListData(){
        Item item = null;
        ArrayList<Item> list = new ArrayList<>();
        for (String[] aData:data){
            item = new Item();
            item.setName(aData[0]);
            item.setPrice(aData[1]);
            item.setPhoto(aData[2]);
            list.add(item);
        }
        return list;
    }
}
