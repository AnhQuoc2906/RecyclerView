package com.classpractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classpractice.adapter.CategoryAdapter;
import com.classpractice.model.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerViewCategory;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        recyclerViewCategory.setLayoutManager(gridLayoutManager);

        categoryAdapter = new CategoryAdapter(categoryList(), this);
        recyclerViewCategory.setAdapter(categoryAdapter);

    }

    private static List<Category> categoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.backpack, "Backpack"));
        categoryList.add(new Category(R.drawable.tshirt, "T-Shirt"));
        categoryList.add(new Category(R.drawable.glasses, "Glassed"));
        categoryList.add(new Category(R.drawable.lipstick, "Lipstick"));
        categoryList.add(new Category(R.drawable.pacifier, "Pacifier"));
        categoryList.add(new Category(R.drawable.shampoo, "Shampoo"));
        categoryList.add(new Category(R.drawable.trainers, "Trainers"));

        return categoryList;
    }
}