package edu.ptit.vhlee.moviedb.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.ptit.vhlee.moviedb.R;
import edu.ptit.vhlee.moviedb.genres.GenresFragment;
import edu.ptit.vhlee.moviedb.nowplaying.NowPlayingFragment;
import edu.ptit.vhlee.moviedb.popular.PopularFragment;
import edu.ptit.vhlee.moviedb.toprate.TopRateFragment;
import edu.ptit.vhlee.moviedb.upcoming.UpcomingFragment;

public class MainActivity extends AppCompatActivity {
    private static final int[] TAB_ICONS = {R.drawable.ic_popular,
            R.drawable.ic_top_rate,
            R.drawable.ic_now_playing,
            R.drawable.ic_upcoming, R.drawable.ic_genres};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * init views in activity
     */
    private void initViews() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        initViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        initTablayoutIcon(tabLayout);
    }

    /**
     * Uupdate tablayout icon
     * @param tabLayout     : Current tablayout
     */
    private void initTablayoutIcon(TabLayout tabLayout) {
        for (int position = 0; position < tabLayout.getTabCount(); position++) {
            tabLayout.getTabAt(position).setIcon(TAB_ICONS[position]);
        }
    }

    /**
     * init viewpager adapter
     * @param viewPager
     */
    private void initViewPager(ViewPager viewPager) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        adapter.addFragment(new PopularFragment(), getString(R.string.title_popular));
        adapter.addFragment(new TopRateFragment(), getString(R.string.title_popular));
        adapter.addFragment(new NowPlayingFragment(), getString(R.string.title_popular));
        adapter.addFragment(new UpcomingFragment(), getString(R.string.title_popular));
        adapter.addFragment(new GenresFragment(), getString(R.string.title_popular));
        viewPager.setAdapter(adapter);
    }
}
