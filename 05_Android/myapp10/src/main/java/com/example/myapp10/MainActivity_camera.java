package com.example.myapp10;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity_camera extends AppCompatActivity {
	
	String filePath;
	ImageView resultImageView;
	Button btnCamera, bntGallery;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_camera);
		
		resultImageView = findViewById(R.id.resultImageView);
		btnCamera = findViewById(R.id.btnCamera);
		bntGallery = findViewById(R.id.bntGallery);
		
		
		// gallery
		ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
				new ActivityResultContracts.StartActivityForResult(),
				new ActivityResultCallback<ActivityResult>() {
					
					@Override
					public void onActivityResult(ActivityResult result) {
						int calRatio = calculateInSampleSize((result.getData().getData()), 300, 300);
						BitmapFactory.Options options = new BitmapFactory.Options();
						options.inSampleSize = calRatio;
						try {
							InputStream inputStream = getContentResolver().openInputStream(result.getData().getData());
							//Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
							Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
							inputStream.close();
							resultImageView.setImageBitmap(bitmap);
						} catch (Exception e) {
							Log.d(">> input stream error", "" + e);
						}
					}
				}
		);
		
		bntGallery.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(Intent.ACTION_PICK);
				intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
				galleryLauncher.launch(intent);
			}
		});
		
		ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
				new ActivityResultCallback<ActivityResult>() {
					
					@Override
					public void onActivityResult(ActivityResult result) {
						Bitmap bitmap = BitmapFactory.decodeFile(filePath);
						resultImageView.setImageBitmap(bitmap);
					}
				});
		
		btnCamera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
				try {
					File file = File.createTempFile("JPEG_" + timeStamp, ".jpg", storageDir);
					filePath = file.getAbsolutePath();
					Log.d(">> file path", "" + filePath);
					
					Uri photoUri = FileProvider.getUriForFile(getBaseContext(), "com.example.myapp10.fileprovider", file);
					
					// camera 가동
					Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					// 정보를 들고 간다
					intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
					
					cameraLauncher.launch(intent);
				} catch (IOException e) {
					e.printStackTrace();
					Log.d(">> error", "" + e);
				}
			}
		});
		
	}
	
	private int calculateInSampleSize(Uri fileUri, int reqWidth, int reqHeight) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		try {
			InputStream inputStream = getContentResolver().openInputStream(fileUri);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}