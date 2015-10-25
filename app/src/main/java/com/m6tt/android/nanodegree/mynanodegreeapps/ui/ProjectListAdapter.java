package com.m6tt.android.nanodegree.mynanodegreeapps.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m6tt.android.nanodegree.mynanodegreeapps.data.Project;
import com.m6tt.android.nanodegree.mynanodegreeapps.R;
import com.m6tt.android.nanodegree.mynanodegreeapps.events.EventBus;
import com.m6tt.android.nanodegree.mynanodegreeapps.events.ProjectListItemClickEvent;
import com.squareup.otto.Bus;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *  ----------------------------------------------
 * My NanoDegree Apps - ProjectListAdapter
 * ----------------------------------------------
 * @author Matt Woodfield
 * @date 24/10/15.
 * @description
 * Adapter to display custom linear list rows with 1 text box and a background colour
 */
public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> implements View.OnClickListener {

    private Bus mBus;

    /** Simple dataset **/
    private Project[] mData;

    public ProjectListAdapter(Project[] data) {
        mData = data;
        mBus = EventBus.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_project_list_item, parent, false);
        view.setOnClickListener(this);

        // Pass view to viewholder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /** Update content per row **/
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Project project = mData[position];
        holder.itemView.setTag(project);
        holder.mItemName.setText(project.getName());
    }

    /** Number of items **/
    @Override
    public int getItemCount() {
        return mData.length;
    }

    /** OnClick event **/

    @Override
    public void onClick(View v) {
        mBus.post(new ProjectListItemClickEvent((Project) v.getTag()));
    }

    /**
     *  ----------------------------------------------
     * My NanoDegree Apps - ProjectListAdapter.ViewHolder
     * ----------------------------------------------
     * @author Matt Woodfield
     * @date 24/10/15.
     * @description
     * Simple Viewholder containing 1 textview
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // For now just a textview
        @Bind(R.id.project_list_item_name)
        TextView mItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
