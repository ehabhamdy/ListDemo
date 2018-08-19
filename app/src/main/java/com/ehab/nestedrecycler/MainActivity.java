package com.ehab.nestedrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewParent;

    ArrayList<Category> parentChildObj;
    ArrayList<Category> dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewParent = findViewById(R.id.rv_parent);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewParent.setLayoutManager(manager);
        recyclerViewParent.setHasFixedSize(true);

        dataset = generateDummyData();
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, dataset);
        recyclerViewParent.setAdapter(categoriesAdapter);

    }

    public void doneClicked(View view) {
        String allSelectedData = "";
        for (int i = 0; i < dataset.size(); i++) {
            ArrayList<Subcategory> subs = dataset.get(i).getSubcategory();
            for (int j = 0; j < subs.size(); j++) {
                if (subs.get(j).isSelected()) {
                    allSelectedData += subs.get(j).getName();
                    allSelectedData += "\n";
                }
            }
        }

        Toast.makeText(this, allSelectedData, Toast.LENGTH_SHORT).show();
    }

    private ArrayList<Category> generateDummyData() {
        parentChildObj = new ArrayList<>();
        ArrayList<Subcategory> list1 = new ArrayList<>();
        ArrayList<Subcategory> list2 = new ArrayList<>();
        ArrayList<Subcategory> list3 = new ArrayList<>();
        ArrayList<Subcategory> list4 = new ArrayList<>();
        ArrayList<Subcategory> list5 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Subcategory c1 = new Subcategory();
            c1.setName("Subcategory 1." + (i + 1));
            list1.add(c1);
        }

        for (int i = 0; i < 5; i++) {
            Subcategory c2 = new Subcategory();
            c2.setName("Subcategory 2." + (i + 1));
            list2.add(c2);
        }


        for (int i = 0; i < 2; i++) {
            Subcategory c3 = new Subcategory();
            c3.setName("Subcategory 3." + (i + 1));
            list3.add(c3);
        }


        for (int i = 0; i < 4; i++) {
            Subcategory c4 = new Subcategory();
            c4.setName("Subcategory 4." + (i + 1));
            list4.add(c4);
        }

        for (int i = 0; i < 2; i++) {
            Subcategory c5 = new Subcategory();
            c5.setName("Subcategory 5." + (i + 1));
            list5.add(c5);
        }


        Category pc1 = new Category();
        pc1.setSubcategory(list1);
        pc1.setHeaderText("Product1");
        parentChildObj.add(pc1);

        Category pc2 = new Category();
        pc2.setSubcategory(list2);
        pc2.setHeaderText("Product2");
        parentChildObj.add(pc2);


        Category pc3 = new Category();
        pc3.setSubcategory(list3);
        pc3.setHeaderText("Product3");
        parentChildObj.add(pc3);

        Category pc4 = new Category();
        pc4.setSubcategory(list4);
        pc4.setHeaderText("Product4");
        parentChildObj.add(pc4);

        Category pc5 = new Category();
        pc5.setSubcategory(list5);
        pc5.setHeaderText("Product5");
        parentChildObj.add(pc5);


        return parentChildObj;
    }

}
