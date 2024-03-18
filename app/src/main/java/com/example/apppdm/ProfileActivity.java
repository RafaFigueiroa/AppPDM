package com.example.apppdm;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ActivityResultLauncher<String> mGetContent =
            registerForActivityResult(new ActivityResultContracts.GetContent(),
                    new ActivityResultCallback<Uri>() {
                        @Override
                        public void onActivityResult(Uri o) {
                            ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);

                            profilePicture.setImageURI(o);
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        changeProfilePicture();
    }

    private void changeProfilePicture() {
        Button editButton = (Button) findViewById(R.id.editButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });
    }
}