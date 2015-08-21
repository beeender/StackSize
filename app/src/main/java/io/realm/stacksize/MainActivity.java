package io.realm.stacksize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.loadLibrary("native");

        TextView textView = (TextView) findViewById(R.id.textView);

        String text = new String();
        text += "Stack Size: " + io.realm.stacksize.StackInfo.getStackSize() + "\n";
        text += "Stack SS: 0x" + Long.toHexString(io.realm.stacksize.StackInfo.getCurStackSS()) + "\n";
        text += "Signal Stack Size: " + io.realm.stacksize.StackInfo.getSignalStackSize() + "\n";
        text += "Signal Stack SP: 0x" + Long.toHexString(io.realm.stacksize.StackInfo.getSignalStackSP()) + "\n";
        textView.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
