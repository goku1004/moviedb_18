package edu.ptit.vhlee.moviedb.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * init views in activity
     */
    private void initViews() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        Toolbar toolbar = findViewById(R.id.toolbar_menu);
        initViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        initTablayoutIcon(tabLayout);
        initMainMenu(drawerLayout, toolbar);
    }

    /**
     * Update tablayout icon
     *
     * @param tabLayout : Current tablayout
     */
    private void initTablayoutIcon(TabLayout tabLayout) {
        for (int position = 0; position < tabLayout.getTabCount(); position++) {
            tabLayout.getTabAt(position).setIcon(TAB_ICONS[position]);
        }
    }

    /**
     * init viewpager adapter
     *
     * @param viewPager
     */
    private void initViewPager(ViewPager viewPager) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        adapter.addFragment(new PopularFragment(), getString(R.string.title_popular));
        adapter.addFragment(new TopRateFragment(), getString(R.string.title_top_rate));
        adapter.addFragment(new NowPlayingFragment(), getString(R.string.title_now_playing));
        adapter.addFragment(new UpcomingFragment(), getString(R.string.title_upcoming));
        adapter.addFragment(new GenresFragment(), getString(R.string.title_genres));
        viewPager.setAdapter(adapter);
    }

    /**
     * init navigation menu
     */

    private void initMainMenu(DrawerLayout drawerLayout, Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        actionBar.setDisplayHomeAsUpEnabled(true);
        new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.text_home, R.string.text_search);
    }
}
