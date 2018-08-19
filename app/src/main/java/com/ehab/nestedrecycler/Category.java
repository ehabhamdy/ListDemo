package com.ehab.nestedrecycler;

import java.util.ArrayList;

public class Category {
    String headerText;
    boolean isSelected;
    ArrayList<Subcategory> subcategory;

    public Category() {
    }

    public ArrayList<Subcategory> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(ArrayList<Subcategory> subcategory) {
        this.subcategory = subcategory;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getHeaderText() {
        return headerText;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}