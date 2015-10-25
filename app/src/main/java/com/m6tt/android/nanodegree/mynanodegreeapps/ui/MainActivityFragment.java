package com.m6tt.android.nanodegree.mynanodegreeapps.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.m6tt.android.nanodegree.mynanodegreeapps.BaseFragment;
import com.m6tt.android.nanodegree.mynanodegreeapps.R;
import com.m6tt.android.nanodegree.mynanodegreeapps.data.StubData;

import butterknife.Bind;


public class MainActivityFragment extends BaseFragment {

    /** RecyclerView **/
    @Bind(R.id.projects_list)
    RecyclerView mRecyclerView;

    /** Custom Adapter **/
    private RecyclerView.Adapter mAdapter;

    /** Recyclerview LayoutManager (will be linear for now) **/
    private RecyclerView.LayoutManager mLayoutManager;

    /** Empty constructor **/
    public MainActivityFragment() { }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Content change wont resize view - improve performance
        mRecyclerView.setHasFixedSize(true);

        // Standard LinearlayoutManager for now
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Custom Adapter
        mAdapter = new ProjectListAdapter(StubData.PROJECT_NAMES);
        mRecyclerView.setAdapter(mAdapter);

    }
}
