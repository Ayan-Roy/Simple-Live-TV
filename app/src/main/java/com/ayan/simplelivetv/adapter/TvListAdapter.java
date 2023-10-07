package com.ayan.simplelivetv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayan.simplelivetv.R;
import com.ayan.simplelivetv.model.LiveTVDataModel;

import java.util.List;

public class TvListAdapter extends RecyclerView.Adapter<TvListAdapter.ViewHolder> {

    private List<LiveTVDataModel> liveTVDataModel;
    private Context context;

    public TvListAdapter(List<LiveTVDataModel> liveTVDataModel, Context context) {
        this.liveTVDataModel = liveTVDataModel;
        this.context = context;

    }

    @NonNull
    @Override
    public TvListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_recycler_chanel_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvListAdapter.ViewHolder holder, int position) {

        holder.tvChanelName.setText(liveTVDataModel.get(position).getChanelName());
        holder.ivChanelImage.setImageResource(liveTVDataModel.get(position).getChanelImage());


    }

    @Override
    public int getItemCount() {
        if (liveTVDataModel != null) {
            return liveTVDataModel.size();
        } else
            return 0;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivChanelImage;
        private TextView tvChanelName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivChanelImage = itemView.findViewById(R.id.row_chanel_image);
            tvChanelName = itemView.findViewById(R.id.row_chanel_name);

        }
    }
}
