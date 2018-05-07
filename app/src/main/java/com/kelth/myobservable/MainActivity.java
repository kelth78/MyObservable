package com.kelth.myobservable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private ObservableInteger a;
    public static final String PARAM = "param";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create observable integer
        a = new ObservableInteger();
        a.setValue(0);

        // Create fragments
        Frag1 frag1 = new Frag1();
        Frag2 frag2 = new Frag2();

        // Put observable int
        Bundle args = new Bundle();
        args.putSerializable(PARAM, a);

        //
        frag1.setArguments(args);
        frag2.setArguments(args);

        getFragmentManager().beginTransaction().add(R.id.fragment, frag1).commit();
        getFragmentManager().beginTransaction().add(R.id.fragment2, frag2).commit();

        // a
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(MainActivity.class.getSimpleName(), "onClick");
                a.setValue(a.getValue() + 1); // Increment value by 1
            }
        });
    }
}
