package com.example.koszykowka;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.koszykowka.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    PunktyViewModel punktyViewModel;

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

        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);

        punktyViewModel.getPunktyGracz1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer value) {
                Integer v = value;
                if (v == null) {
                    v = 0;
                }
                if (!binding.switchGracze.isChecked()) {
                    binding.textViewLicznik.setText(String.valueOf(v));
                }
                int p1 = v;
                Integer tmp2 = punktyViewModel.getPunktyGracz2().getValue();
                int p2;
                if (tmp2 == null) {
                    p2 = 0;
                } else {
                    p2 = tmp2;
                }
                binding.textViewWynik.setText("Gracz1: " + p1 + "  Gracz2: " + p2);
            }
        });

        punktyViewModel.getPunktyGracz2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer value) {
                Integer v = value;
                if (v == null) {
                    v = 0;
                }
                if (binding.switchGracze.isChecked()) {
                    binding.textViewLicznik.setText(String.valueOf(v));
                }
                int p2 = v;
                Integer tmp1 = punktyViewModel.getPunktyGracz1().getValue();
                int p1;
                if (tmp1 == null) {
                    p1 = 0;
                } else {
                    p1 = tmp1;
                }
                binding.textViewWynik.setText("Gracz1: " + p1 + "  Gracz2: " + p2);
            }
        });

        binding.buttonPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.switchGracze.isChecked()) {
                    punktyViewModel.addPunktyGracza(2, 1);
                } else {
                    punktyViewModel.addPunktyGracza(1, 1);
                }
            }
        });

        binding.buttonPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.switchGracze.isChecked()) {
                    punktyViewModel.addPunktyGracza(2, 2);
                } else {
                    punktyViewModel.addPunktyGracza(1, 2);
                }
            }
        });

        binding.buttonPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.switchGracze.isChecked()) {
                    punktyViewModel.addPunktyGracza(2, 3);
                } else {
                    punktyViewModel.addPunktyGracza(1, 3);
                }
            }
        });

        binding.switchGracze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.switchGracze.setText("Gracz 2");
                } else {
                    binding.switchGracze.setText("Gracz 1");
                }
                Integer val;
                if (isChecked) {
                    val = punktyViewModel.getPunktyGracz2().getValue();
                } else {
                    val = punktyViewModel.getPunktyGracz1().getValue();
                }
                if (val == null) {
                    val = 0;
                }
                binding.textViewLicznik.setText(String.valueOf(val));
                Integer tmp1 = punktyViewModel.getPunktyGracz1().getValue();
                int p1;
                if (tmp1 == null) {
                    p1 = 0;
                } else {
                    p1 = tmp1;
                }
                Integer tmp2 = punktyViewModel.getPunktyGracz2().getValue();
                int p2;
                if (tmp2 == null) {
                    p2 = 0;
                } else {
                    p2 = tmp2;
                }
                binding.textViewWynik.setText("Gracz1: " + p1 + "  Gracz2: " + p2);
            }
        });

        binding.switchGracze.setChecked(false);

        Integer tmp1 = punktyViewModel.getPunktyGracz1().getValue();
        int p1;
        if (tmp1 == null) {
            p1 = 0;
        } else {
            p1 = tmp1;
        }
        Integer tmp2 = punktyViewModel.getPunktyGracz2().getValue();
        int p2;
        if (tmp2 == null) {
            p2 = 0;
        } else {
            p2 = tmp2;
        }
        binding.textViewWynik.setText("Gracz1: " + p1 + "  Gracz2: " + p2);
    }
}