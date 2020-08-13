package com.erikshop.animewallpaper;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.UUID;

import Helper.SaveImageHelper;
import Utils.Utils;

public class ViewWallpaperActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fabDownload,fabWallpaper;
    ImageView il;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);

        final Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                WallpaperManager manager  = WallpaperManager.getInstance(getApplicationContext());
                try {
                    manager.setBitmap(bitmap);
                    Toast.makeText(ViewWallpaperActivity.this, "Done", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(ViewWallpaperActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                Toast.makeText(ViewWallpaperActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        initialize();

        Picasso.get().load(Utils.selected_wallpaper.getImageLink()).into(il);

        fabWallpaper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Picasso.get().load(Utils.selected_wallpaper.getImageLink()).into(target);


            }
        });

        fabDownload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String fileName = UUID.randomUUID().toString() + ".png";

                AlertDialog.Builder b = new AlertDialog.Builder(ViewWallpaperActivity.this);
                b.setMessage("Downloading..");
                AlertDialog alertDialog = b.create();
                alertDialog.show();

                Picasso.get().load(Utils.selected_wallpaper.getImageLink()).into(new SaveImageHelper(getBaseContext(),alertDialog,getApplicationContext().getContentResolver(),fileName,"Mini Image"));

            }
        });

    }

    private void initialize(){
        il = (ImageView)findViewById(R.id.thumbImage);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);
        fabDownload = (FloatingActionButton)findViewById(R.id.fab_download);
        fabWallpaper = (FloatingActionButton)findViewById(R.id.fab_wallpaper);

        collapsingToolbarLayout.setTitle(Utils.CATEGORY_SELECTED);

    }

}
