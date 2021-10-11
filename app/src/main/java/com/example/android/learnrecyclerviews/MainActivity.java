package com.example.android.learnrecyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        final ArrayList<ItsCode> itsCodes = new ArrayList<ItsCode>();
        itsCodes.add(new ItsCode(getString(R.string.activity_main_xml),
                R.drawable.activity_main_xml));
        itsCodes.add(new ItsCode(getString(R.string.main_activity_java),
                R.drawable.main_activity_java));
        itsCodes.add(new ItsCode(getString(R.string.activity_detail_xml),
                R.drawable.activity_detail_xml));
        itsCodes.add(new ItsCode(getString(R.string.detail_activity_java),
                R.drawable.detail_activity_java));
        itsCodes.add(new ItsCode(getString(R.string.its_code_java),
                R.drawable.its_code_java));
        itsCodes.add(new ItsCode(getString(R.string.card_caption_image_xml),
                R.drawable.card_caption_image_xml));
        itsCodes.add(new ItsCode(getString(R.string.captioned_images_adapter_java),
                R.drawable.captioned_images_adapter_java));
        itsCodes.add(new ItsCode(getString(R.string.strings_xml),
                R.drawable.strings_xml));

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(itsCodes);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getApplication(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_CODE_POSITION,
                        itsCodes.get(position));
                getApplication().startActivity(intent);
            }
        });
    }
}
