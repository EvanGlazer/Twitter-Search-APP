package com.evanglazer.twitter_search_app;// MainActivity.java
// Manages your favorite Twitter searches for easy  
// access and display in the device's web browser


import java.util.ArrayList;
import java.util.Collections;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.evanglazer.twitter_search_app.R;

import static com.evanglazer.twitter_search_app.R.layout.list_item;

public class MainActivity extends ListActivity {
    // name of SharedPreferences XML file that stores the saved searches
    private static final String SEARCHES = "searches";

    private EditText queryEditText; // EditText where user enters a query
    private EditText tagEditText; // EditText where user tags a query
    private SharedPreferences savedSearches; // user's favorite searches
    private ArrayList<String> tags; // list of tags for saved searches
    private ArrayAdapter<String> adapter; // binds tags to ListView

    // called when MainActivity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // get references to the EditTexts
        queryEditText = (EditText) findViewById(R.id.queryEditText);
        tagEditText = (EditText) findViewById(R.id.tagEditText);

        // get the SharedPreferences containing the user's saved searches
        savedSearches = getSharedPreferences(SEARCHES, MODE_PRIVATE);

        // store the saved tags in an ArrayList then sort them
        tags = new ArrayList<String>(savedSearches.getAll().keySet());
        Collections.sort(tags, String.CASE_INSENSITIVE_ORDER);

        // create ArrayAdapter and use it to bind tags to the ListView
        adapter = new ArrayAdapter<String>(this, list_item, tags);


        setListAdapter(adapter);

        // register listener to save a new or edited search
        ImageButton saveButton = (ImageButton) findViewById(R.id.saveButton);
       // saveButton.setOnClickListener(saveButtonListener);

        // register listener that searches Twitter when user touches a tag
        //getListView().setOnItemClickListener(itemClickListener);

        // set listener that allows user to delete or edit a search
        //getListView().setOnItemLongClickListener(itemLongClickListener);
    }

}