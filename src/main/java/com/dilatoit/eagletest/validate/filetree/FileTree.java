package com.dilatoit.eagletest.validate.filetree;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salt on 2017/9/24.
 */
public class FileTree {
    @Expose
    private String id;

    @Expose
    private String text;

    @Expose
    private String icon;

    @Expose
    private String tag;

    @Expose
    private NodeState state;

    @Expose
    private List<FileTree> children;

    FileTree() {
        this.id = "";
        this.text = "";
        this.icon = "";
        this.children = new ArrayList<>();
    }

     FileTree(String id, String text, String icon) {
        this.id = id;
        this.text = text;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    public List<FileTree> getChildren() {
        return children;
    }

    public void setChildren(List<FileTree> children) {
        this.children = children;
    }
}
