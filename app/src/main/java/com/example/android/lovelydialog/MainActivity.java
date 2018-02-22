package com.example.android.lovelydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yarolegovich.lovelydialog.LovelyChoiceDialog;
import com.yarolegovich.lovelydialog.LovelyCustomDialog;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;
import com.yarolegovich.lovelydialog.LovelyProgressDialog;
import com.yarolegovich.lovelydialog.LovelySaveStateHandler;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnStandard,btnInfo,btnTextInput,btnChoice,btnProgress,btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Views
        btnStandard = findViewById(R.id.btnStandardDialog);
        btnInfo = findViewById(R.id.btnIfoDialog);
        btnTextInput = findViewById(R.id.btnTextInputDialog);
        btnChoice = findViewById(R.id.btnChoicesDialog);
        btnProgress = findViewById(R.id.btnProgressDialog);
        btnCustom = findViewById(R.id.btnCustomDialog);


        //Events
        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LovelyStandardDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrimary)
                        .setButtonsColorRes(R.color.colorAccent)
                        .setIcon(R.drawable.ic_star)
                        .setTitle("Rate My App")
                        .setMessage("Please rate my app")
                        .setPositiveButton(android.R.string.ok, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                .setNegativeButton(android.R.string.no,null)
                .show();
            }
        });


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LovelyInfoDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrimary)
                        .setIcon(R.drawable.ic_info)
                        .setNotShowAgainOptionEnabled(0)
                        .setNotShowAgainOptionChecked(false)
                        .setTitle("Benqy")
                        .setMessage("Hello From AYOUB!")
                        .show();
            }
        });

        btnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*//Single Choice
                new LovelyChoiceDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrimary)
                        .setIcon(R.drawable.ic_choices)
                        .setTitle("Options")
                        .setMessage("Please choose")
                        .setItems(generateString(), new LovelyChoiceDialog.OnItemSelectedListener<String>() {
                            @Override
                            public void onItemSelected(int position, String item) {
                                Toast.makeText(MainActivity.this, ""+item, Toast.LENGTH_SHORT).show();
                            }
                        }).show();*/


                //Multi Choices
                new LovelyChoiceDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrimary)
                        .setIcon(R.drawable.ic_choices)
                        .setTitle("Options")
                        .setMessage("Please choose")
                        .setItemsMultiChoice(generateString(), new LovelyChoiceDialog.OnItemsSelectedListener<String>() {

                            @Override
                            public void onItemsSelected(List<Integer> positions, List<String> items) {
                                for (String item:items)
                                    Log.d("MULTI_CHOICES",item);
                            }
                        }).show();


            }
        });


        btnTextInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LovelyTextInputDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrimary)
                        .setIcon(R.drawable.ic_assessment)
                        .setTitle("Enter text")
                        .setMessage("Please enter your text")
                        .setInputFilter("Please enter text", new LovelyTextInputDialog.TextFilter() {
                            @Override
                            public boolean check(String text) {
                                return text.matches("\\w+");
                            }
                        }).setConfirmButton(android.R.string.ok, new LovelyTextInputDialog.OnTextInputConfirmListener() {
                    @Override
                    public void onTextInputConfirmed(String text) {
                        Toast.makeText(MainActivity.this, ""+text, Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });


        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LovelyProgressDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrimary)
                        .setIcon(R.drawable.ic_info)
                        .setTitle("Connecting...")
                        .setCancelable(true)
                        .show();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LovelyCustomDialog(MainActivity.this)
                        .setView(R.layout.custom_layout)
                        .setTopColorRes(R.color.colorPrimary)
                        .setIcon(R.drawable.ic_info)
                        .setTitle("Custom view")
                        .setMessage("This is custom view")
                        .show();
            }
        });

    }

    private List<String> generateString() {
        List<String> result = new ArrayList<>();
        result.add("One");
        result.add("Two");
        result.add("Three");
        result.add("Four");
        result.add("Five");

        return result;
    }
}
