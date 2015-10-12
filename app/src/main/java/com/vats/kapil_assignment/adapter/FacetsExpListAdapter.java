package com.vats.kapil_assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.vats.kapil_assignment.R;
import com.vats.kapil_assignment.model.Facet;
import com.vats.kapil_assignment.model.FacetResultEntry;

import java.util.List;

/**
 * Created by Kapil on 10/12/2015.
 */
public class FacetsExpListAdapter extends BaseExpandableListAdapter {

    private List<Facet> mFacets;
    private Context mContext;
    private LayoutInflater mLayoutInflater;


    public FacetsExpListAdapter(Context context, List<Facet> facets) {
        this.mContext = context;
        this.mFacets = facets;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mFacets.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mFacets.get(i).getFacetResultEntries().size();
    }

    @Override
    public Object getGroup(int i) {
        return mFacets.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mFacets.get(i).getFacetResultEntries().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder = null;
        if (view == null) {
            groupViewHolder = new GroupViewHolder();
            view =  mLayoutInflater.inflate(R.layout.view_facets_item, viewGroup, false);
            groupViewHolder.txtFacetName = (TextView) view.findViewById(R.id.txt_facet_name);
            view.setTag(groupViewHolder);

        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        Facet facet = (Facet) getGroup(i);
        groupViewHolder.txtFacetName.setText(facet.getCode().toUpperCase());
        groupViewHolder.txtFacetName.setCompoundDrawablesWithIntrinsicBounds(0,0,b?R.drawable.minus:R.drawable.plus,0);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder = null;
        if (view == null) {
            childViewHolder = new ChildViewHolder();
            view =  mLayoutInflater.inflate(R.layout.view_facets_child_item, viewGroup, false);
            childViewHolder.txtFacetItem = (TextView) view.findViewById(R.id.txt_facet_item);
            view.setTag(childViewHolder);

        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
        }
        FacetResultEntry facetResultEntry = (FacetResultEntry) getChild(i, i1);
        String text = facetResultEntry.getTerm() + "(" + facetResultEntry.getCount() + ")";
        childViewHolder.txtFacetItem.setText(text);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    static class GroupViewHolder {
        TextView txtFacetName;


    }

    static class ChildViewHolder {
        TextView txtFacetItem;
    }

}
