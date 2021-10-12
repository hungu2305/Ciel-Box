package vn.edu.usth.cielbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Maininterface extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView nBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maininterface);

        mViewPager = findViewById(R.id.view_pager);
        nBottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        nBottomNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;

                    case 1:
                        nBottomNavigationView.getMenu().findItem(R.id.menu_file).setChecked(true);
                        break;

                    case 2:
                        nBottomNavigationView.getMenu().findItem(R.id.menu_image).setChecked(true);
                        break;

                    case 3:
                        nBottomNavigationView.getMenu().findItem(R.id.menu_video).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        nBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        mViewPager.setCurrentItem(0);
                        HomeFragment homeFragment = (HomeFragment) mViewPager.getAdapter().instantiateItem(mViewPager, 0);
                        homeFragment.reloadData();
                        break;

                    case R.id.menu_file:
                        mViewPager.setCurrentItem(1);
                        break;

                    case R.id.menu_image:
                        mViewPager.setCurrentItem(2);
                        break;

                    case R.id.menu_video:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}