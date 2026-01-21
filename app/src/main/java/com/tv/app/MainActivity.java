package com.tv.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BrowseSupportFragment browseFragment = (BrowseSupportFragment) 
                getSupportFragmentManager().findFragmentById(R.id.main_browse_fragment);

        if (browseFragment != null) {
            // This sets the title in the top right, like Plex
            browseFragment.setTitle("IPTV PLAYER");
            // This sets the color of the sidebar
            browseFragment.setBrandColor(getResources().getColor(android.R.color.black));
            
            loadRows(browseFragment);
        }
    }

    private void loadRows(BrowseSupportFragment fragment) {
        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        
        // This creates your first "Plex" category
        HeaderItem header = new HeaderItem(0, "LIVE TV");
        rowsAdapter.add(new ListRow(header, new ArrayObjectAdapter())); // We will fill this next

        fragment.setAdapter(rowsAdapter);
    }
}
