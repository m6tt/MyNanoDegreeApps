package com.m6tt.android.nanodegree.mynanodegreeapps.data;

import android.graphics.Color;

/**
 *  ----------------------------------------------
 * My NanoDegree Apps - Project
 * ----------------------------------------------
 * @author Matt Woodfield
 * @date 24/10/15.
 * @description
 * Project model object
 */
public class Project {
    private String mName;
    private int mColour; // Not used for now, might use for text colour

    public Project(String name) {
        mName = name;
    }

    public Project(String name, int colour) {
        mName = name;
        mColour = colour;
    }

    public String getName() {
        return mName;
    }

    public int getColour() {
        return mColour;
    }
}
