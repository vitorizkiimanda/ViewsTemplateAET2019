package id.codepanda.viewstemplateaet2019;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mTextView;
    Button mImageView;
    Button mEditView;
    Button mLinearLayout;
    Button mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();
        onClickListener();
    }

    private void binding(){
        mTextView = findViewById(R.id.button_text_view);
        mImageView = findViewById(R.id.button_image_view);
        mEditView = findViewById(R.id.button_edit_view);
        mLinearLayout = findViewById(R.id.button_linear_layout);
        mConstraintLayout = findViewById(R.id.button_constraint_layout);
    }

    private void onClickListener(){
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(TextViewActivity.class);
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(ImageViewActivity.class);
            }
        });
        mEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(EditTextActivity.class);
            }
        });
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(LinearLayoutActivity.class);
            }
        });
        mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(ConstraintLayoutActivity.class);
            }
        });
    }

    private void intent(Class destination){
        Intent open = new Intent(MainActivity.this, destination);
        startActivity(open);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_author) {
            intent(AuthorActivity.class);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
