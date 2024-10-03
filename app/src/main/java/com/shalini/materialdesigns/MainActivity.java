package com.shalini.materialdesigns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //private FloatingActionButton fab;
    private ConstraintLayout parent;
    private Button showSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.parent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        fab = findViewById(R.id.fab);
//        fab.setOnClickListener(v->{
//            Toast.makeText(MainActivity.this, "Please select", Toast.LENGTH_SHORT).show();
//        });

        parent = findViewById(R.id.parent);
        showSnackBar = findViewById(R.id.showSnackBar);
        showSnackBar.setOnClickListener(v->{
            setShowSnackBar();
        });
    }

    public  void setShowSnackBar(){
        Snackbar.make(parent, "Hello", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry",new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Retry clicked", Toast.LENGTH_SHORT).show();
                    }
        }).setActionTextColor(getColor(R.color.white))
                .show();
    }
}