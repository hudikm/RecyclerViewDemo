package sk.fri.uniza.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView smallImageView;
    TextView contentText;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        contentText = itemView.findViewById(R.id.contentTxt);
        smallImageView = itemView.findViewById(R.id.smallImage);
    }

}
