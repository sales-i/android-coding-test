package com.salesi.coding;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.salesi.coding.ui.adapter.TabsAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.layout_tabs) protected TabLayout mTabLayout;
    @Bind(R.id.view_pager) protected ViewPager mViewPager;
    @Bind(R.id.toolbar) protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager(), getApplicationContext());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.exit_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected (MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.want_to_exit);
            builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int arg) {
                    finish();
                }
            });

            builder.setNegativeButton(R.string.cancel, null);
            AlertDialog areyousureDialog = builder.create();
            areyousureDialog.show();
            }

            // possibly other menu items

        return true;
    }
}
