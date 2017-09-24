package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    Button TopButton;
    Button ButtomButton;
    TextView Story;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            index=savedInstanceState.getInt("IndexKey");

        }else{
            index=0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        TopButton=(Button) findViewById(R.id.buttonTop);
        ButtomButton=(Button)findViewById(R.id.buttonBottom);
        Story=(TextView)findViewById(R.id.storyTextView);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        //originally I have created the conditions without the use of indexes but since it was required i added them
        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==0||TopButton.getText().equals(TopButton.getResources().getString(R.string.T2_Ans1))){
                    Story.setText(R.string.T3_Story);
                    TopButton.setText(R.string.T3_Ans1);
                    ButtomButton.setText(R.string.T3_Ans2);
                    index=1;
                }
                else if(index==1){
                    Story.setText(R.string.T6_End);
                    TopButton.setVisibility(View.INVISIBLE);
                    ButtomButton.setVisibility(View.INVISIBLE);
                    index=0;

                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        ButtomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==0){
                    Story.setText(R.string.T2_Story);
                    TopButton.setText(R.string.T2_Ans1);
                    ButtomButton.setText(R.string.T2_Ans2);
                    index++;
                }
                else if(index==1&&ButtomButton.getText().equals(ButtomButton.getResources().getString(R.string.T3_Ans2))){
                    Story.setText(R.string.T5_End);
                    TopButton.setVisibility(View.INVISIBLE);
                    ButtomButton.setVisibility(View.INVISIBLE);
                    index=0;
                }
                else if(index==1&&ButtomButton.getText().equals(ButtomButton.getResources().getString(R.string.T2_Ans2))){
                    Story.setText(R.string.T4_End);
                    TopButton.setVisibility(View.INVISIBLE);
                    ButtomButton.setVisibility(View.INVISIBLE);
                    index=0;
                }

            }});


    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey",index);

    }


}
