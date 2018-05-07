package com.kelth.myobservable;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class Frag2 extends Fragment {

    private ObservableInteger a1;
    private Observer a1Changed = new Observer() {
        @Override
        public void update(Observable observable, Object newValue) {
            // a1 changed!
            Log.d(Frag2.class.getSimpleName(), "a1 changed: " + (int) newValue);
            TextView tw = getView().findViewById(R.id.value2);
            tw.setText(Integer.toString((int)newValue));
        }
    };

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Get observable integer
            a1 = (ObservableInteger) getArguments().getSerializable(((MainActivity)getActivity()).PARAM);
            // Add listener for value change
            a1.addObserver(a1Changed);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false);
    }
}
