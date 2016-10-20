package com.example.santander.pocporquinho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private PorquinhoFragment mPorquinhoFragment;

//    Animation slideUpAnimation, slideDownAnimation;
//    ImageView imageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.slide_up_down_animation_layout);
//
//        imageView = (ImageView) findViewById(R.id.imageView);
//
//        slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.slide_up_animation);
//
//        slideDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.slide_down_animation);
//
//    }
//
//    public void startSlideUpAnimation(View view) {
//        imageView.startAnimation(slideUpAnimation);
//    }
//
//    public void startSlideDownAnimation(View view) {
//        imageView.startAnimation(slideDownAnimation);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPorquinhoFragment = (PorquinhoFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_porquinho);

    }
}
