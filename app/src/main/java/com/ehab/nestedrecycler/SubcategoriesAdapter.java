package com.ehab.nestedrecycler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubcategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Subcategory> subcategoryData;

    public SubcategoriesAdapter(ArrayList<Subcategory> subcategoryData) {
        this.subcategoryData = subcategoryData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_child)
        TextView tvChild;
        @BindView(R.id.iv_expand_collapse_toggle)
        ImageView tvExpandCollapseToggle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subcategory, parent, false);


        SubcategoriesAdapter.ViewHolder vh = new SubcategoriesAdapter.ViewHolder(itemLayoutView);
        return vh;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;

        if (position == subcategoryData.size() - 1) {
            viewHolder.tvExpandCollapseToggle.setImageResource(R.drawable.ic_stat_name);
            viewHolder.tvExpandCollapseToggle.setVisibility(View.VISIBLE);
        } else {
            viewHolder.tvExpandCollapseToggle.setVisibility(View.GONE);
        }

        final Subcategory c = subcategoryData.get(position);
        viewHolder.tvChild.setText(c.getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setSelected(!c.isSelected);
                if (c.isSelected)
                    viewHolder.tvChild.setTextColor(Color.RED);
                else
                    viewHolder.tvChild.setTextColor(Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subcategoryData.size();
    }
}
