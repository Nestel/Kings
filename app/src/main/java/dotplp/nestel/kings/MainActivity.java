package dotplp.nestel.kings;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity
{
    private final int NUM_OF_CARDS = 52;
    private final int NUM_OF_COLORED_CARDS = 13;

    private int[][] CARDS;

    private int cardsDrawn = 1;

    private TextView textView;
    private TextView cardsLeftTextView;
    private ImageView cardImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.textView);
        this.cardsLeftTextView = (TextView) findViewById(R.id.cardsLeftTextView);
        this.cardImageView = (ImageView) findViewById(R.id.cardImageView);

        this.CARDS = new int[NUM_OF_CARDS][2];

        char nothing;

        initCardsArray();
    }

    public void gameButtonClick(View v)
    {
        if (v instanceof Button)
        {
            Button button = (Button) v;
            ((Button) v).setText("Draw card");
        }

        if ( checkGameOver() == 0 )
        {
            this.cardsLeftTextView.setText("Cards left: " + Integer.toString(NUM_OF_CARDS - this.cardsDrawn) + "\n");
            evaluateCard(getRandomCard());
            cardsDrawn++;
        }
        else
        {
            this.cardImageView.setVisibility(View.GONE);
            this.textView.setText("\n==============================\n\nAll cards have been used\n\n==============================\n\n");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initCardsArray()
    {
        int i;

        for ( i = 0; i < NUM_OF_CARDS; i++ )
        {
            CARDS[i][0] = i%NUM_OF_COLORED_CARDS;
            CARDS[i][1] = 0;
        }
    }

    private int getRandomCard()
    {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNumber = rand.nextInt(NUM_OF_CARDS);

        while ( CARDS[randomNumber][1] == 1 )
        {
            randomNumber = rand.nextInt(NUM_OF_CARDS);
        }

        CARDS[randomNumber][1] = 1;

        return randomNumber%NUM_OF_COLORED_CARDS;
    }

    private void evaluateCard(int randomNumber)
    {
        switch (randomNumber)
        {
            case 0:
                this.cardImageView.setImageResource(R.drawable.hearts2);
                //this.textView.setText("Potiahol si si 2.\n\nTHUMB !!");
                this.textView.setText("THUMB !!");
                break;
            case 1:
                this.cardImageView.setImageResource(R.drawable.hearts3);
                //this.textView.setText("Potiahol si si 3.\n\nKATEGORIE !!");
                this.textView.setText("KATEGORIE !!");
                break;
            case 2:
                this.cardImageView.setImageResource(R.drawable.hearts4);
                //this.textView.setText("Potiahol si si 4.\n\nRYMY !!");
                this.textView.setText("RYMY !!");
                break;
            case 3:
                this.cardImageView.setImageResource(R.drawable.hearts5);
                //this.textView.setText("Potiahol si si 5.\n\nDOTKNI SA ZEME !!");
                this.textView.setText("DOTKNI SA ZEME !!");
                break;
            case 4:
                this.cardImageView.setImageResource(R.drawable.hearts6);
                //this.textView.setText("Potiahol si si 6.\n\nOTAZKY !!");
                this.textView.setText("OTAZKY !!");
                break;
            case 5:
                this.cardImageView.setImageResource(R.drawable.hearts7);
                //this.textView.setText("Potiahol si si 7.\n\nRUKA HORE BRACHOOOO !!");
                this.textView.setText("RUKA HORE BRACHOOOO !!");
                break;
            case 6:
                this.cardImageView.setImageResource(R.drawable.hearts8);
                //this.textView.setText("Potiahol si si 8.\n\nURCI OSOBU, KTORA SA NAPIJE !!");
                this.textView.setText("URCI OSOBU, KTORA SA NAPIJE !!");
                break;
            case 7:
                this.cardImageView.setImageResource(R.drawable.hearts9);
                //this.textView.setText("Potiahol si si 9.\n\nNAPI SA !!");
                this.textView.setText("NAPI SA !!");
                break;
            case 8:
                this.cardImageView.setImageResource(R.drawable.hearts10);
                //this.textView.setText("Potiahol si si 10.\n\nURCI NIEKOHO KTO BUDE ODTERAZ PIT S TEBOU !!");
                this.textView.setText("URCI NIEKOHO KTO BUDE ODTERAZ PIT S TEBOU !!");
                break;
            case 9:
                this.cardImageView.setImageResource(R.drawable.jack_of_hearts);
                //this.textView.setText("Potiahol si si J.\n\nURCI PRAVIDLO !!");
                this.textView.setText("URCI PRAVIDLO !!");
                break;
            case 10:
                this.cardImageView.setImageResource(R.drawable.queen_of_hearts);
                //this.textView.setText("Potiahol si si Q.\n\nPIJU BABY !!");
                this.textView.setText("PIJU BABY !!");
                break;
            case 11:
                this.cardImageView.setImageResource(R.drawable.king_of_hearts);
                //this.textView.setText("Potiahol si si K.\n\nPIJU CHALANI");
                this.textView.setText("PIJU CHALANI");
                break;
            case 12:
                this.cardImageView.setImageResource(R.drawable.ace_of_hearts);
                //this.textView.setText("Potiahol si si A.\n\nI HAVE NEVER EVER ...");
                this.textView.setText("I HAVE NEVER EVER ...");
                break;
        }
    }

    private int checkGameOver()
    {
        int i;

        for ( i = 0; i < NUM_OF_CARDS; i++ )
        {
            if ( CARDS[i][1] == 0 )
            {
                return 0;
            }
        }

        return 1;
    }

    private int main()
    {


        return 0;
    }
}
