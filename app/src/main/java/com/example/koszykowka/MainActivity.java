package com.example.koszykowka;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.koszykowka.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // klasa z bindowaymi widokami dla pliku activity main xml jest activitymain binding
    PunktyViewModel punktyViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktyViewModel = new ViewModelProvider(this)
                .get(PunktyViewModel.class);
        // korzystne by zapisywac pliki przy obracaniu
      punktyViewModel.getPunkty().observe(this,
              new Observer<Integer>() {
                  @Override
                  public void onChanged(Integer integer) {
                      binding.textViewLicznik.setText(""+integer);
                  }
              }
      );
        binding.buttonPlus1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPunkty(1);
                    }
                });
                binding.buttonPlus2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
punktyViewModel.addPunkty(2);
                            }
                        });
        binding.buttonPlus3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
punktyViewModel.addPunkty(3);
                    }
                });


    }
}