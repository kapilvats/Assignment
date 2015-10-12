package com.vats.kapil_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.vats.kapil_assignment.adapter.FacetsExpListAdapter;
import com.vats.kapil_assignment.data.ResponseParser;
import com.vats.kapil_assignment.model.Facet;
import com.vats.kapil_assignment.model.ProductResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author Kapil Vats
 */
public class ProductActivity extends AppCompatActivity {


    /**
     * Expandable list view containing the list of facets
     */
    private ExpandableListView mExpandableListView;

    /**
     * Json parser helper
     */
    private ResponseParser mResponseParser;

    /**
     * List adapter for holding and displaying the item in ExpandableListView
     */
    private FacetsExpListAdapter mFacetsExpListAdapter;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mExpandableListView = (ExpandableListView) findViewById(R.id.exp_list_facets);
        mResponseParser = new ResponseParser(this);
        ProductResponse productResponse = null;
        try {
            productResponse = mResponseParser.parse();
            ((TextView)findViewById(R.id.txt_product_size)).setText("Total Product : "+productResponse.getTotalCount());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(productResponse!=null){
            loadData(productResponse.getFacets());
        }else{
            // Set the empty message
        }

    }

    /**
     * Load data into the adapter
     * @param facets
     */
    private void loadData(List<Facet> facets){
        mFacetsExpListAdapter = new FacetsExpListAdapter(this,facets);
        setListAdapter();
    }


    /**
     * Set the list adapter into the list
     */
    private void setListAdapter(){
        if(mFacetsExpListAdapter!=null && mExpandableListView!=null){
            mExpandableListView.setAdapter(mFacetsExpListAdapter);
        }
    }

}
