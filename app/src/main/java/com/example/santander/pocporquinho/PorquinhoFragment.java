package com.example.santander.pocporquinho;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Santander on 19/10/16.
 */

public class PorquinhoFragment extends android.support.v4.app.Fragment{

    private Button mDragButton;

    private View mLayout;
    private boolean isLoginShowing = false;
    private RelativeLayout relativeLayoutContainer;
    private Button buttonInvestir;
    private boolean isDragging = false;
    private int initailY = 0;
    private boolean insercaoBtn = true;

    private RelativeLayout relativeBoxRosa;

    private RelativeLayout relativeBoxAzul;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLayout = inflater.inflate(R.layout.fragment_porquinho, container, false);

//        mDragButton = (Button) mLayout.findViewById(R.id.button_drag);
//        mDragButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                onActionContainer(v, event);
//                return false;
//            }
//        });
//
//        relativeBoxRosa = (RelativeLayout) mLayout.findViewById(R.id.relative_box_rosa);
//
//        buttonInvestir = (Button) mLayout.findViewById(R.id.button_investir);
//        buttonInvestir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                relativeBoxAzul.setY(-1200f);
//                relativeBoxRosa.setVisibility(View.INVISIBLE);
//                //onActionContainer();
//            }
//        });
//
//
//
//        relativeBoxAzul = (RelativeLayout) mLayout.findViewById(R.id.relative_box_azul);
//
//
//
//        RelativeLayout relativeLingua = (RelativeLayout) mLayout.findViewById(R.id.button_lingua);
//        relativeLingua.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                //onActionContainer(v, event);
//                return false;
//            }
//        });


//        ViewTreeObserver vto = layout.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                int width  = layout.getMeasuredWidth();
//                int height = layout.getMeasuredHeight();
//                //TODO: code
//                System.out.println("Layout Height : "+height+ "and Layuot Width : "+width);
//            }
//        });

        return mLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDragButton = (Button) mLayout.findViewById(R.id.button_drag);
        mDragButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onActionContainer(v, event);
                return false;
            }
        });

        relativeBoxRosa = (RelativeLayout) mLayout.findViewById(R.id.relative_box_rosa);

        buttonInvestir = (Button) mLayout.findViewById(R.id.button_investir);
        buttonInvestir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeBoxAzul.setY(-1200f);
                relativeBoxRosa.setVisibility(View.INVISIBLE);
                //onActionContainer();
            }
        });



        relativeBoxAzul = (RelativeLayout) mLayout.findViewById(R.id.relative_box_azul);



        RelativeLayout relativeLingua = (RelativeLayout) mLayout.findViewById(R.id.button_lingua);
        relativeLingua.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //onActionContainer(v, event);
                return false;
            }
        });

//        int inicioLingua = relativeBoxAzul.getHeight()+relativeBoxRosa.getHeight()+200;
//        relativeBoxAzul.setY(-inicioLingua);

        relativeBoxAzul.setY(-1200f);

    }

    private void onActionContainer(View v, MotionEvent event){
        int y = (int) event.getRawY();
        Log.v("event.getRawY =", String.valueOf(y));
        int topo = getFragmentlayoutHeight();

        y = y - 200 - relativeBoxRosa.getHeight()  - relativeBoxAzul.getHeight();

//        Log.v("ScreenHeight =", String.valueOf(getScreenHeight()));
//        Log.v("FragmentlayoutHeight =", String.valueOf(getFragmentlayoutHeight()));
//        Log.v("DragButtonHeight =", String.valueOf(getDragButtonHeight()));

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v("ACTION_DOWN", "ACTION_DOWN");
                initailY = (int) event.getRawY();

                break;

            case MotionEvent.ACTION_UP:
                Log.v("ACTION_UP", "ACTION_UP");
                if (isLoginShowing) {
                    //sobe o container
                    //relativeLayoutContainer.setVisibility(View.VISIBLE);
                    //animateLayoutParams(getFragmentlayoutHeight(), getDragButtonHeight());
                } else {
                    //desce o container
                    //relativeLayoutContainer.setVisibility(View.INVISIBLE);
                    //animateLayoutParams(getFragmentlayoutHeight(), getScreenHeight());
                }

                break;

            case MotionEvent.ACTION_MOVE:
                Log.v("ACTION_MOVE", String.valueOf(y));
//                isDragging = !(initailY <= y + getDragButtonHeight()/2 && initailY >= y - getDragButtonHeight()/2);
//
//                int height = (getScreenHeight() - y) + (getDragButtonHeight() / 2);
//                Log.v("height =", String.valueOf(height));
//
//                if (height >= getDragButtonHeight()) {
//                    Log.v("FragmentLayoutHeight =", String.valueOf(height));
//                    setFragmentLayoutHeight(height);
//                }

                    //setFragmentLayoutHeight(y);

                    if(y < 153)
                    relativeBoxAzul.setY(y);
                else
                        Log.v("travou =", "travou");


                break;
        }

    }

    private void onActionContainer(){

            if (isLoginShowing) {
                //sobe o container
                relativeLayoutContainer.setVisibility(View.VISIBLE);
                animateLayoutParams(getFragmentlayoutHeight(), getDragButtonHeight());
            } else {
                //desce o container
                relativeLayoutContainer.setVisibility(View.INVISIBLE);
                animateLayoutParams(getFragmentlayoutHeight(), getScreenHeight());
            }

    }

    private void animateLayoutParams(int fromHeight, int toHeight) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(fromHeight, toHeight);
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //setFragmentLayoutHeight((Integer) animation.getAnimatedValue());
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isLoginShowing = getFragmentlayoutHeight() > (getScreenHeight() / 5);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    public void setFragmentLayoutHeight(int height) {
        ViewGroup.LayoutParams layoutParams =  mLayout.getLayoutParams();
        layoutParams.height = height;
        mLayout.setLayoutParams(layoutParams);


        //if(convertPxToDp(main.getHeight()) < 400){

//            if(insercaoBtn){
//                RelativeLayout relativeLayoutBtn = new RelativeLayout(getContext());
//                RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(100,20);
//                layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//                layoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
//                layoutParams1.setMargins(0,height,0,0);
//                relativeLayoutBtn.setLayoutParams(layoutParams1);
//                relativeLayoutBtn.setBackgroundColor(Color.BLUE);
//
//
//                RelativeLayout relativeLayout = (RelativeLayout) mLayout.findViewById(R.id.relative_main);
//                relativeLayout.addView(relativeLayoutBtn);
//                insercaoBtn = false;
//            }
//            else {
//
//            }
        //}




        //if(convertPxToDp(main.getHeight()) < 400)

        RelativeLayout main = (RelativeLayout) mLayout.findViewById(R.id.relative_container_main);

        Log.v("HEIGHT====", String.valueOf(convertPxToDp(main.getHeight())));

        moveBtnLingua(main.getHeight());

    }

    private void moveBtnLingua(int height){
        RelativeLayout relativeLayout = (RelativeLayout) mLayout.findViewById(R.id.button_lingua);
        relativeLayout.setY(height);



    }

    private int convertPxToDp(int px){
        return Math.round(px/(Resources.getSystem().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));
    }

    public int getScreenHeight() {
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    public int getDragButtonHeight() {
        return mDragButton.getMeasuredHeight();
    }

    public int getFragmentlayoutHeight() {
        return mLayout.getMeasuredHeight();
    }

    private int getTopoFragment(){
        return 1;
    }
}
