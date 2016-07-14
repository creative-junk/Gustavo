package com.crysoft.me.gustavo;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crysoft.me.gustavo.fragments.CartFragment;
import com.crysoft.me.gustavo.fragments.HomeFragment;
import com.crysoft.me.gustavo.fragments.RepairFragment;
import com.crysoft.me.gustavo.fragments.ShopFragment;
import com.crysoft.me.gustavo.fragments.StoreFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,StoreFragment.OnFragmentInteractionListener,CartFragment.OnFragmentInteractionListener,ShopFragment.OnFragmentInteractionListener,RepairFragment.OnFragmentInteractionListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_discover,
            R.drawable.ic_location,
            R.drawable.ic_help,
            R.drawable.ic_cart
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabs();

    }

    private void setupTabs() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new ShopFragment());
        adapter.addFragment(new StoreFragment());
        adapter.addFragment(new RepairFragment());
        adapter.addFragment(new CartFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment){
            mFragmentList.add(fragment);
        }
    }
}
