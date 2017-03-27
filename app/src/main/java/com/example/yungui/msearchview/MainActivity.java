package com.example.yungui.msearchview;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ClipData;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        setSearchView(menu);
        searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        //关联检索配置与SearchView
        SearchManager searchManager = (SearchManager) this.getSystemService(SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(new
                ComponentName(getApplication(), searchActivity.class));
        searchView.setSearchableInfo(searchableInfo);
        return super.onCreateOptionsMenu(menu);
    }
    /*
    初始化searchview
     */
    private void setSearchView(Menu menu) {
        MenuItem item = menu.getItem(0);
        SearchView searchView = new SearchView(this);
        searchView.setIconifiedByDefault(true);
        searchView.setQueryHint("搜索");
        searchView.setSubmitButtonEnabled(true);
        item.setActionView(searchView);
    }


}
