package com.example.root.menuambfragmentdemo1;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    Button btn_add;
    Button btn_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Setup(){
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_remove = (Button) findViewById(R.id.btn_remove);
        btn_add.setOnClickListener(v -> addFragment());
        btn_remove.setOnClickListener(v -> removeFragment());
    }

    public void addFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                    .replace(R.id.fragment_container, BlankFragment.newInstance(null,null))
                        .commit();
    }

    public void removeFragment(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_about:
                Toast.makeText(this, "About us", Toast.LENGTH_LONG).show();
                //indica que hem consumit l'event
                return true;
            case R.id.item_foo:
                Toast.makeText(this," Foo", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item_bar:
                Toast.makeText(this, "Bar", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.item_about);
        item.setEnabled(!item.isEnabled());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


