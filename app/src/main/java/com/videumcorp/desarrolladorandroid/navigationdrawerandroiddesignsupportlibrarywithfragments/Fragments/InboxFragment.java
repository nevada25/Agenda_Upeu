package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.MainActivity;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.R;

import java.util.Timer;
import java.util.TimerTask;


public class InboxFragment extends Fragment {
    private ImageSwitcher imageSwitcher1;
    private int[] gallery = {R.drawable.u, R.drawable.a, R.drawable.p};
    private int position;
    private static final Integer DURATION = 2000;
    private Timer timer = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("INICIO");


        imageSwitcher1 = (ImageSwitcher) view.findViewById(R.id.imageSwitcher);

        imageSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                View v = new ImageView(getActivity());
                return v;
            }
        });

        Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
        imageSwitcher1.setInAnimation(fadeIn);
        imageSwitcher1.setOutAnimation(fadeOut);
        startSlider();












      //  Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentInbox);

        /* final TextView textViewInboxFragment = (TextView) view.findViewById(R.id.textViewInboxFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewInboxFragment.setText("This is the Inbox Fragment");
                textViewInboxFragment.setTextColor(getResources().getColor(R.color.md_yellow_800));

            }
        });
*/
        return view;
    }
    private void startSlider() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageSwitcher1.setImageResource(gallery[position]);
                        position++;
                        if (position == gallery.length) {
                            position = 0;
                        }
                    }
                });
            }

            private void runOnUiThread(Runnable runnable) {

            }
        }, 0, DURATION);

    }

}
