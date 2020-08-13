package CategoryViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erikshop.animewallpaper.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.imageView);
        textView = (TextView)itemView.findViewById(R.id.textView);


    }
}
