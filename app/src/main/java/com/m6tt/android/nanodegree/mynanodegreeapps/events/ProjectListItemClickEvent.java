package com.m6tt.android.nanodegree.mynanodegreeapps.events;

import com.m6tt.android.nanodegree.mynanodegreeapps.data.Project;

/**
 *  ----------------------------------------------
 * My NanoDegree Apps - ProjectListItemClickEvent
 * ----------------------------------------------
 * @author Matt Woodfield
 * @date 24/10/15.
 * @description
 * Event object containing name as public var
 */
public class ProjectListItemClickEvent {
    private Project mProject;

    public ProjectListItemClickEvent(Project project) {
        mProject = project;
    }

    public Project getProject() {
        return mProject;
    }
}
