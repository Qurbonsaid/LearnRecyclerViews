package com.example.android.learnrecyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CODE_POSITION = "codePosition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ItsCode currentItsCode = (ItsCode)
                getIntent().getExtras().getSerializable(EXTRA_CODE_POSITION);

        ImageView imageView = (ImageView) findViewById(R.id.detailed_code_image_view);
        imageView.setImageResource(currentItsCode.getImageResourceId());
    }
}
