package e.taufan.customerapps.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import e.taufan.customerapps.Data.PesananData;
import e.taufan.customerapps.Object.Pesan;
import e.taufan.customerapps.R;

public class PesanFragment extends Fragment {
    private ArrayList<Pesan> list;
    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_pesan, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


//        recyclerView = (RecyclerView) view.findViewById(R.id.rv_transaction);
//        recyclerView.setHasFixedSize(true);
//        ListPesananAdapter listPesananAdapter = new ListPesananAdapter(list,getActivity());
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(listPesananAdapter);
        return  view;

    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new PesananMasukFragment(), "Notifikasi");
        adapter.addFragment(new PesananSelesaiFragment(), "Dokumen");
        viewPager.setAdapter(adapter);

    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.addAll(PesananData.getListData());
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public MyPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
