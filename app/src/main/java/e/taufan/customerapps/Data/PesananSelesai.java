package e.taufan.customerapps.Data;

import java.util.ArrayList;

import e.taufan.customerapps.Object.Pesan;

public class PesananSelesai {

    public static String[][] data = new String[][]{
            {"213011627", "27-1-2019 00:00", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"},
            {"213011628", "24-1-2019 00:00", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"},
    };

    public static ArrayList<Pesan> getListData(){
        Pesan pesan = null;
        ArrayList<Pesan> list = new ArrayList<>();
        for(String[] aData : data){
            pesan = new Pesan();
            pesan.setID_TRANS(aData[0]);
            pesan.setTANGGAL(aData[1]);
            pesan.setPHOTO(aData[2]);
            list.add(pesan);
        }
        return list;
    }
}
