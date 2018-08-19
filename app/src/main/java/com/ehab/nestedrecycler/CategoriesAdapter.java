package com.ehab.nestedrecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Category> dataset;
    private Context context;

    public CategoriesAdapter(Context context, ArrayList<Category> dataSet) {
        this.context = context;
        this.dataset = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        CategoriesAdapter.ViewHolder pavh = new CategoriesAdapter.ViewHolder(itemLayoutView);
        return pavh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        final Category p = dataset.get(position);
        viewHolder.mainTextView.setText(p.getHeaderText());
        initChildLayoutManager(viewHolder.subcategoriesRecyclerview, p.getSubcategory());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setSelected(!p.isSelected());
                if (p.isSelected)
                    viewHolder.subcategoriesRecyclerview.setVisibility(View.VISIBLE);
                else
                    viewHolder.subcategoriesRecyclerview.setVisibility(View.GONE);
            }
        });
        if (p.isSelected)
            viewHolder.subcategoriesRecyclerview.setVisibility(View.VISIBLE);
        else
            viewHolder.subcategoriesRecyclerview.setVisibility(View.GONE);
    }

    private void initChildLayoutManager(RecyclerView rv_child, ArrayList<Subcategory> subcategoryData) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_child.setLayoutManager(manager);
        SubcategoriesAdapter subcategoriesAdapter = new SubcategoriesAdapter(subcategoryData);
        rv_child.setAdapter(subcategoriesAdapter);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.subcategories_recyclerview)
        RecyclerView subcategoriesRecyclerview;

        @BindView(R.id.text_main)
        TextView mainTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}