package com.example.flashlight.flashlight;

import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private ImageButton onOff;
    private boolean isLight;
    private Camera camera ;
	private int test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onOff = (ImageButton)findViewById(R.id.on_Off);
        onOff.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Camera.Parameters parameters;
        switch (view.getId()) {
            case R.id.on_Off:
                if (!isLight) {
                    //onOff.setBackground(getResources().getDrawable(R.drawable.bulb_on));
                    onOff.setBackgroundResource(R.drawable.bulb_on);
                    camera = Camera.open();
                    parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    isLight = true;
                }
                else {
                    onOff.setBackgroundResource(R.drawable.bulb_off);
                    parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.release();
                    isLight = false;
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
