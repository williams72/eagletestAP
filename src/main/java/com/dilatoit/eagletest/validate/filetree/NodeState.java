package com.dilatoit.eagletest.validate.filetree;

import com.google.gson.annotations.Expose;

/**
 * Created by Salt on 2017/9/24.
 */
public class NodeState {
    @Expose
    private boolean opened;

    @Expose
    private boolean selected;

    NodeState(){

    }

    public NodeState(boolean opened) {
        this.opened = opened;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
