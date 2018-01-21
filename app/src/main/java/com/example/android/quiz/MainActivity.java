package com.example.android.quiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.devprovider.customview.ToggleButtonGroupTableLayout;

public class MainActivity extends AppCompatActivity {

    ToggleButtonGroupTableLayout radioGroup;
    EditText ed;
    LinearLayout checkboxLayout;
    ImageView image;
    TextView result,question,wrongansw,rightTextview,wrongTextView,rightCount,tile;
    Button gforward;
    String[] youranswer = new String[6];
    String[] yourawnswer_notChanged = new String[6];
    CheckBox ch1,ch2,ch3,ch4;
    boolean ch_1,ch_2,ch_3,ch_4;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed= (EditText)findViewById(R.id.editText);

        radioGroup =(ToggleButtonGroupTableLayout)findViewById(R.id.radiogoup);
        result = (TextView)findViewById(R.id.result);
        question = (TextView)findViewById(R.id.question);
        wrongansw = (TextView)findViewById(R.id.wrongCount);
        rightTextview = (TextView)findViewById(R.id.rightOnes);
        wrongTextView = (TextView)findViewById(R.id.wrongOnes);
        rightCount = (TextView)findViewById(R.id.rightOnesCount);
        tile = (TextView)findViewById(R.id.tile);
        image = (ImageView) findViewById(R.id.image);
        checkboxLayout=(LinearLayout)findViewById(R.id.checkboxlayout);
        ch1 = (CheckBox)findViewById(R.id.ch1);
        ch2 = (CheckBox)findViewById(R.id.ch2);
        ch3 = (CheckBox)findViewById(R.id.ch3);
        ch4 = (CheckBox)findViewById(R.id.ch4);

        gforward = (Button)findViewById(R.id.goforward);

        gforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    forward();
            }
        });

        rightTextview.setVisibility(View.GONE);

        tile.setVisibility(View.GONE);

    }
        public void forward ()
    {
        if(i<6) {
            youranswer[i] = ed.getText().toString().toLowerCase();
            yourawnswer_notChanged[i] = ed.getText().toString();
        }
        i++;
        if(i==1)
        {
            gforward.setText(getResources().getString(R.string.next));
            image.setImageResource(R.drawable.islilaipinimas);
            question.setText(getResources().getString(R.string.question1));
            ed.setVisibility(View.VISIBLE);
            ed.setHint(getResources().getString(R.string.Q1Hint));
        }

        if(i==2) {
            image.setImageResource(R.drawable.apolo11);
            question.setText(getResources().getString(R.string.question2));
            ed.setHint(getResources().getString(R.string.Q2Hint));
         }
        if(i==3) {
            image.setImageResource(R.drawable.gorilaz);
            question.setText(getResources().getString(R.string.question3));
            ed.setHint(getResources().getString(R.string.Q3Hint));
        }
        if(i==4) {
            image.setImageResource(R.drawable.normandija);
            question.setText(getResources().getString(R.string.question4));
            ed.setHint(getResources().getString(R.string.Q4Hint));
        }
        if(i==5) {
            image.setImageResource(R.drawable.optika);
            question.setText(getResources().getString(R.string.question5));
            ed.setHint(getResources().getString(R.string.Q5Hint));
        }
        if (i==6)
        {
            ed.setVisibility(View.GONE);
            question.setText(getResources().getString(R.string.question6));
            checkboxLayout.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.queen);
        }
        if (i==7)
        {
            checkboxLayout.setVisibility(View.GONE);
            question.setText(getResources().getString(R.string.question7));
            image.setImageResource(R.drawable.litcountry);
            radioGroup.setVisibility(View.VISIBLE);
        }
        if(i==8)
        {
            radioGroup.setVisibility(View.GONE);
            ch_1=chh1();
            ch_2=chh2();
            ch_3=chh3();
            ch_4=chh4();


            int right=0;
            int wrong=0;
            String ch="";
            String radioAns="";
           if(youranswer[1].contains(getResources().getString(R.string.Y1969)))
               right++;
           else wrong++;

            if(youranswer[2].matches(getResources().getString(R.string.APOLLO_11))|youranswer[2].matches(getResources().getString(R.string.APOLO_11)) |youranswer[2].matches(getResources().getString(R.string.APOLO11))| youranswer[2].matches(getResources().getString(R.string.APOLLO11))|youranswer[2].matches(getResources().getString(R.string.APOLO_11)))
                right++;
            else wrong++;

            if(youranswer[3].matches(getResources().getString(R.string.GORILLAZ))|youranswer[3].matches(getResources().getString(R.string.GORILAZ))|youranswer[3].matches(getResources().getString(R.string.GORILAZZ)))
                right++;
            else wrong++;

            if(youranswer[4].contains(getResources().getString(R.string.Y1945)))
                right++;
            else wrong++;

            if(youranswer[5].matches(getResources().getString(R.string.OPTIC))|youranswer[5].matches(getResources().getString(R.string.OPTICS)))
                right++;
           else wrong++;
            if((!ch_1&&!ch_3) && (ch_2&&ch_4))
                right++;
            else wrong++;

            if(ch_1)
             ch+= getResources().getString(R.string.BRIAN_MAY);
            if (ch_2)
                ch+= getResources().getString(R.string.ANGUS_YOUNG);
            if (ch_3)
                ch+= getResources().getString(R.string.ROGER_TAYLOR);
            if (ch_4)
                ch+= getResources().getString(R.string.CHRIS_SLADE);

            if(radioGroup.getCheckedRadioButtonId() == R.id.Lithuania)
            {
                right++;
                radioAns+= getResources().getString(R.string.Radiobutton2);
            }
            else if (radioGroup.getCheckedRadioButtonId() == R.id.Slovakia) {
                wrong++;
                radioAns+= getResources().getString(R.string.Radiobutton4);
            }
            else if (radioGroup.getCheckedRadioButtonId() == R.id.Mexico)
            {
                wrong++;
                radioAns+= getResources().getString(R.string.Radiobutton3);
            }
            else if(radioGroup.getCheckedRadioButtonId() == R.id.Belgium)
            {
                wrong++;
                radioAns+= getResources().getString(R.string.Radiobutton1);
            }
            else
                wrong++;

            String ans;
            ans= getResources().getString(R.string.RIGHT_ANSWER1) + getResources().getString(R.string.YOUR_ANSWER) + yourawnswer_notChanged[1]+"\n";
            ans+= getResources().getString(R.string.RIGHT_ANSWER2) + getResources().getString(R.string.YOUR_ANSWER) + yourawnswer_notChanged[2]+"\n";
            ans+= getResources().getString(R.string.RIGHT_ANSWER3) + getResources().getString(R.string.YOUR_ANSWER) + yourawnswer_notChanged[3]+"\n";
            ans+= getResources().getString(R.string.RIGHT_ANSWER4) + getResources().getString(R.string.YOUR_ANSWER) + yourawnswer_notChanged[4]+"\n";
            ans+= getResources().getString(R.string.RIGHT_ANSWER5) + getResources().getString(R.string.YOUR_ANSWER) + yourawnswer_notChanged[5]+"\n";
            ans+= getResources().getString(R.string.RIGHT_ANSWER6) + getResources().getString(R.string.YOUR_ANSWER) + ch+ "\n";
            ans+= getResources().getString(R.string.RIGHT_ANSWER7) + getResources().getString(R.string.YOUR_ANSWER) + radioAns+ "\n";

            question.setVisibility(View.GONE);

            image.setVisibility(View.GONE);

            ed.setVisibility(View.GONE);

            result.setVisibility(View.VISIBLE);

            rightTextview.setVisibility(View.VISIBLE);
            rightTextview.setText(getResources().getString(R.string.CORRECT_ANSWERS));

            wrongTextView.setVisibility(View.VISIBLE);
            wrongTextView.setText(getResources().getString(R.string.WRONG_ANSWERS));

            tile.setVisibility(View.VISIBLE);
            tile.setText(ans);

            RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, R.id.rightOnesCount);
            gforward.setLayoutParams(params);

            gforward.setText(getResources().getString(R.string.START_AGAIN));
            gforward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                    }
            });
            wrongansw.setText(""+wrong);
            rightCount.setText(""+right);

            Toast toast = Toast.makeText(this, getResources().getString(R.string.MADE_BY_JUSTAS_GLODENIS), Toast.LENGTH_SHORT);
            toast.show();
            }
    }
    public boolean chh1() {
        boolean c = ch1.isChecked();
        return c;
    }
    public boolean chh2() {
        boolean c = ch2.isChecked();
        return c;
    }
    public boolean chh3 () {
        boolean c = ch3.isChecked();
        return c;
    }
    public boolean chh4() {
        boolean c = ch4.isChecked();
        return c;

    }
}
