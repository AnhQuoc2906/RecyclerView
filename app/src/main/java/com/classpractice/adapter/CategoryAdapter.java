package com.classpractice.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.classpractice.DetailActivity;
import com.classpractice.R;
import com.classpractice.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final List<Category> mCategoryList;

    private final Context mContext;

    public CategoryAdapter(List<Category> mCategoryList, Context context) {
        this.mCategoryList = mCategoryList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mCategoryList.get(position);
        if (category == null) return;
        holder.name.setText(category.getName());
        holder.image.setImageResource(category.getResourceId());
        holder.category = category; // for intent to detail page
    }

    @Override
    public int getItemCount() {
        if (mCategoryList != null)
            return mCategoryList.size();
        return 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView name;
        private Category category;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imv_category_image);
            name = itemView.findViewById(R.id.tv_category_name);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("category", category);
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);
        }
    }
}
