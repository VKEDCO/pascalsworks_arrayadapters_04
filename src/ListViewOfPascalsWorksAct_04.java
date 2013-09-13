package org.vkedco.mobappdev.listviewofpascalsworks_arrayadptrs_04;

/*
 ************************************************************ 
 * IDE: Eclipse Juno
 * OS: Ubuntu 12.04 LTS
 * bugs to vladimir dot kulyukin at gmail dot com
 ************************************************************
 */

import android.os.Bundle;
import android.app.ListActivity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewOfPascalsWorksAct_04 extends ListActivity {
	
	static String[] mPascalsTitles = null;
	static int[] mPascalsYears = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.list_view_of_pascals_works_act_layout_04);
        
        Resources res = this.getResources();
        mPascalsTitles = res.getStringArray(R.array.pascals_titles);
        ArrayAdapter<CharSequence> adptr
			= ArrayAdapter.createFromResource(this, 
					R.array.pascals_titles,
					R.layout.list_item_layout);
        this.setListAdapter(adptr);
        mPascalsYears = res.getIntArray(R.array.pascals_titles_years);
        
        this.getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View child,
					int position, long id) {
				// we cannot specify this as
				// the first argument to makeText, because we are inside
				// OnItemClickListener,
				// not inside the ListActivity where we were in
				// ListViewArrayAdapter1Act.
				// Thus, we have to getApplicationContext() explicitly.
				Toast t = Toast.makeText(getApplicationContext(), 
						Integer.toString(mPascalsYears[position]),
						Toast.LENGTH_LONG);
				t.show();
			}

			
		});
	}

    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_of_pascals_works_act_04, menu);
        return true;
    }
    
}
