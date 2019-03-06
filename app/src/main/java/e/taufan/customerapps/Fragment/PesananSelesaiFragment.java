package e.taufan.customerapps.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.taufan.customerapps.Adapter.ListPesananAdapter;
import e.taufan.customerapps.Data.PesananSelesai;
import e.taufan.customerapps.Object.Pesan;
import e.taufan.customerapps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananSelesaiFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<Pesan> list;

    public PesananSelesaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pesan_masuk, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_transaction);
        recyclerView.setHasFixedSize(true);
        ListPesananAdapter listPesananAdapter = new ListPesananAdapter(list,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listPesananAdapter);
        return view;
    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.addAll(PesananSelesai.getListData());
    }

}
