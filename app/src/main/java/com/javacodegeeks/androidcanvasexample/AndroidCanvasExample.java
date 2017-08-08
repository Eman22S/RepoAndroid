package com.javacodegeeks.androidcanvasexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.UUID;

public class AndroidCanvasExample extends Activity {

	private CanvasView customCanvas;
    private int count=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
	}

	public void clearCanvas(View v) {
		customCanvas.clearCanvas();
	}
	public void clearCount(View view){
        count=0;
    }

	public void saveDrawing(View view){

//		AlertDialog.Builder saveDialog= new AlertDialog.Builder(this);
//		saveDialog.setTitle("Save Drawing");
//		saveDialog.setMessage("Save Drawing ?");
//		saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
				customCanvas.setDrawingCacheEnabled(true);
				String imgSaved= MediaStore.Images.Media.insertImage(getContentResolver(), customCanvas.getDrawingCache(), UUID.randomUUID().toString()+".png", "drawing");

				if(!imgSaved.equals(null)){
					count=count+1;
					String display_count="Count is"+count;
					Toast.makeText(this, display_count, Toast.LENGTH_LONG).show();
					Toast.makeText(this, "Drawing saved to Gallery!", Toast.LENGTH_SHORT).show();


				}
				else{
					Toast.makeText(this, "Oops! Image could not be saved.", Toast.LENGTH_SHORT).show();

				}

//			}
//		});
//
//		saveDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
	//		@Override
	//		public void onClick(DialogInterface dialog, int which) {
	//			dialog.cancel();
	//		}
	//	});
	//	saveDialog.show();

	}

}