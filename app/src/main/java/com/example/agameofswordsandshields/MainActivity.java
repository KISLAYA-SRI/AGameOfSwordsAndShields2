package com.example.agameofswordsandshields;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                arr[i][j]=0;
        }
    }

    //1 is sword and 2 is shield
    int actply=1;
    int arr[][] = new int[3][3];
    boolean gameon = true;


    public void drop(View view)
    {
        ImageView ctr = (ImageView)view;
        Log.i("Tag ", ctr.getTag().toString());
        if(gameon)
        {
            int tag = Integer.parseInt(ctr.getTag().toString());
            int row = tag / 3;
            int col = tag % 3;
            if (arr[row][col] == 0)
            {
                arr[row][col] = actply;
                ctr.setTranslationY(-2000);

                if (actply == 1)
                {
                    ctr.setImageResource(R.drawable.sword1);
                    actply = 2;
                } else {
                    ctr.setImageResource(R.drawable.sheild);
                    actply = 1;
                }
                ctr.animate().translationYBy(2000).setDuration(300);

                if (Win_sword()) {
                    TextView edit = (TextView) findViewById((R.id.textViewsword));
                    edit.setText("Sword has Won!!!");
                    gameon = false;
                    Button playa = (Button)findViewById(R.id.button);
                }
                if (Win_shield()) {
                    TextView edit = (TextView) findViewById((R.id.textViewsword));
                    edit.setText("Sheild has Won!!!");
                    gameon = false;
                    Button playa = (Button)findViewById(R.id.button);
                }

            } else {
                //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void playagain(View view)
    {
        //Button playa = (Button)findViewById(R.id.button);

        TextView edit = (TextView) findViewById((R.id.textViewsword));
        edit.setText("");

        for(int i=0;i<3;i++)
        {
            for (int j = 0; j < 3; j++)
                arr[i][j] = 0;
        }
        gameon = true;
        actply=1;
        Log.i("ON CLICK", "Button Pressed");

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout11);
        Log.i("ON CLICK", "Button Pressed 1");
        Log.i("ON CLICK", Integer.toString(gridLayout.getRowCount()));
        for(int i=0; i<gridLayout.getChildCount(); i++)
        {
            ImageView ctr = (ImageView)gridLayout.getChildAt(i);
            ctr.setImageDrawable(null);
            Log.i("ON CLICK", "Button Pressed 2");
        }
    }

    public boolean Win_sword()
    {
        if(arr[0][0]==1 && arr[0][1]==1 && arr[0][2]==1)
            return true;

        else if(arr[1][0]==1 && arr[1][1]==1 && arr[1][2]==1)
            return true;

        else if(arr[2][0]==1 && arr[2][1]==1 && arr[2][2]==1)
            return true;

        else if(arr[0][0]==1 && arr[1][0]==1 && arr[2][0]==1)
            return true;

        else if(arr[0][1]==1 && arr[1][1]==1 && arr[2][1]==1)
            return true;

        else if(arr[0][2]==1 && arr[1][2]==1 && arr[2][2]==1)
            return true;

        else if(arr[0][0]==1 && arr[1][1]==1 && arr[2][2]==1)
            return true;

        else if(arr[0][2]==1 && arr[1][1]==1 && arr[2][0]==1)
            return true;

        else
            return false;
    }

    public boolean Win_shield()
    {
        if(arr[0][0]==2 && arr[0][1]==2 && arr[0][2]==2)
            return true;

        else if(arr[1][0]==2 && arr[1][1]==2 && arr[1][2]==2)
            return true;

        else if(arr[2][0]==2 && arr[2][1]==2 && arr[2][2]==2)
            return true;

        else if(arr[0][0]==2 && arr[1][0]==2 && arr[2][0]==2)
            return true;

        else if(arr[0][1]==2 && arr[1][1]==2 && arr[2][1]==2)
            return true;

        else if(arr[0][2]==2 && arr[1][2]==2 && arr[2][2]==2)
            return true;

        else if(arr[0][0]==2 && arr[1][1]==2 && arr[2][2]==2)
            return true;

        else if(arr[0][2]==2 && arr[1][1]==2 && arr[2][0]==2)
            return true;

        else
            return false;

    }
}
