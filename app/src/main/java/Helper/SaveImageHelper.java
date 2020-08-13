package Helper;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

public class SaveImageHelper implements Target {

    Context context;
    WeakReference<AlertDialog> alertDialogWeakReference;
    WeakReference<ContentResolver> contentResolverWeakReference;
    String name,desc;

    public SaveImageHelper(Context context,AlertDialog alertDialog,ContentResolver contentResolver,String name,String desc){

        this.context = context;
        alertDialogWeakReference = new WeakReference<AlertDialog>(alertDialog);
        contentResolverWeakReference = new WeakReference<ContentResolver>(contentResolver);
        this.name = name;
        this.desc = desc;

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

        ContentResolver c = contentResolverWeakReference.get();
        AlertDialog aD = alertDialogWeakReference.get();

        if (c != null) {
            MediaStore.Images.Media.insertImage(c,bitmap,name,desc);
            aD.dismiss();
            Toast.makeText(context,"Image Downloaded successfully",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
    }
}
