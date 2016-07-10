package com.example.thesam.myapplication;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieChart pieChart;
    private ArrayList<Entry> data;
    private ArrayList<String> label;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // UI references

        fab = (FloatingActionButton) findViewById(R.id.add);
        pieChart = (PieChart) findViewById(R.id.chart);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        coordinatorLayout.setRotationX(60.0F);
        coordinatorLayout.animate().rotationX(0.0F).setDuration(3000);

        //label initialisation

        label = new ArrayList<>();
        label.add("Algerie");
        label.add("Maroc");
        label.add("TUnisie");
        //data initialisation

        data = new ArrayList<>();
        data.add(new Entry(0.2f, 0));
        data.add(new Entry(0.2f, 1));
        data.add(new Entry(0.50f, 2));
        final PieDataSet dataSet = new PieDataSet(data, "data");
        final PieData pieData = new PieData(label, dataSet);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieChart.setCenterText("Pie Chart");
        pieChart.setData(pieData);
        pieChart.animateY(1000);
        pieChart.setBackgroundColor(5);
        pieData.setDrawValues(true);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Adding Action", Snackbar.LENGTH_LONG)
                        .setAction("Dismis", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                snackbar.setActionTextColor(Color.RED);

                snackbar.show();
            }
        });
        pieChart.notifyDataSetChanged();
    }
}
