package com.example.leafidentifier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

class MyExpandableListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String>titles;
    Map<String, List<String>> points;

    public MyExpandableListAdapter(Context context, List<String> titles, Map<String, List<String>> points) {
        this.context = context;
        this.titles = titles;
        this.points = points;
    }


    @Override
    public int getGroupCount() {
        return titles.size(); //count of number of titles
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return points.get(titles.get(groupPosition)).size(); //count of number of children of a parent
    }

    @Override
    public Object getGroup(int groupPosition) {
        return titles.get(groupPosition); // gives group/parent name
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return points.get(titles.get(groupPosition)).get(childPosition); //returns child name
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_parent, null);
        }
        TextView parentTextView = (TextView) convertView.findViewById(R.id.parentTextView);
        parentTextView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String point = (String) getChild(groupPosition, childPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_child, null);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.childTextView);
        childTextView.setText(point);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
