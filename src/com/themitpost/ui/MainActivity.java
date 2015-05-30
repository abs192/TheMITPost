package com.themitpost.ui;

import java.util.Stack;

import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.themitpost.R;
import com.themitpost.ui.adapters.DrawerLayoutAdapter;
import com.themitpost.ui.adapters.TabPagerAdapter;
import com.themitpost.ui.view.SlidingTabLayout;
import com.themitpost.utils.Utilities;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private String actionBarTitle;
	private ActionBarDrawerToggle mDrawerToggle;
	private static int position;
	private Stack<Integer> stackFrags;
	public DrawerLayoutAdapter mDrawerListAdapter;
	private ActionBar ab;
	private Toolbar toolbar;
	private TabPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		setSupportActionBar(toolbar);

		initActionBar();
		initTabs();
	}

	private void initActionBar() {
		ab = getSupportActionBar();
		if (ab != null) {
			mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			mDrawerList = (ListView) findViewById(R.id.left_drawer);
			LayoutParams layoutParams = (LayoutParams) mDrawerList
					.getLayoutParams();
			Point screenSize = Utilities.getRealScreenSize();
			layoutParams.width = Utilities.isTablet() ? Utilities.dp(320)
					: Math.min(screenSize.x, screenSize.y) - Utilities.dp(56);

			// mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
			// GravityCompat.START);
			mDrawerListAdapter = new DrawerLayoutAdapter(this);
			mDrawerList.setAdapter(mDrawerListAdapter);
			mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
			mDrawerListAdapter.notifyDataSetChanged();

			ab.setDisplayShowTitleEnabled(false);
			ab.setDisplayHomeAsUpEnabled(true);
			ab.setDisplayShowHomeEnabled(true);
			ab.setDisplayShowCustomEnabled(true);
			ab.setHomeButtonEnabled(true);
			// title = (TextView) actionBar.getCustomView().findViewById(
			// R.id.title);
			// title.setTextAppearance(getApplicationContext(),
			// R.style.CardTitle);
			// title.setTypeface(null, Typeface.BOLD);
			// title.setTextColor(Color.parseColor("#eeeeee"));

			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					R.string.drawer_open, R.string.drawer_close) {

				public void onDrawerClosed(View view) {
					ab.setTitle(actionBarTitle);
					invalidateOptionsMenu();
				}

				public void onDrawerOpened(View drawerView) {
					ab.setTitle(actionBarTitle);
					invalidateOptionsMenu();
				}
			};
			mDrawerLayout.setDrawerListener(mDrawerToggle);
		}
	}

	private void initTabs() {
		adapter = new TabPagerAdapter(getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.tabpager);
		pager.setAdapter(adapter);

		SlidingTabLayout tabs = (SlidingTabLayout) findViewById(R.id.tabs);
		tabs.setDistributeEvenly(true);

		tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
			@Override
			public int getIndicatorColor(int position) {
				return getResources().getColor(R.color.tabsScrollColor);
			}
		});
		tabs.setViewPager(pager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_search).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
				mDrawerLayout.closeDrawer(mDrawerList);
			} else {
				mDrawerLayout.openDrawer(mDrawerList);
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	class DrawerItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			if (position != pos)
				selectDrawerItem(pos);
			else
				mDrawerLayout.closeDrawer(mDrawerList);
		}

	}

	private void selectDrawerItem(int pos) {
		// Fragment fragment = null;
		// // switch on pos ^^^^^^^^
		// fragment = new TabsFragment();
		// if (fragment != null) {
		// FragmentManager fragmentManager = getSupportFragmentManager();
		// fragmentManager.beginTransaction()
		// .replace(R.id.content_frame, fragment).commit();
		// }
		// mDrawerLayout.closeDrawer(mDrawerList);
	}
}
