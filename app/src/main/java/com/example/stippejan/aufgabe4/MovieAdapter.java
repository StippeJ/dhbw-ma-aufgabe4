package com.example.stippejan.aufgabe4;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    // Data of this list will be shown in the RecyclerView
    private final List<Movie> movieList;

    // Constructor
    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    // Inflating the item-layout and creating a ViewHolder
    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(v);
    }

    // Setting the content for all Views of each item
    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie m = movieList.get(position);
        holder.title.setText(m.getTitle());
        holder.rating.setText(String.format("%.1f", m.getImdbScore()));
        holder.yearDuration.setText(m.getYear() + ", " + m.getDuration());
        holder.cast.setText(TextUtils.join(", ", m.getCast()));
        if (m.getAudioSynchronized()) {
            holder.audioSynchronized.setImageResource(R.drawable.ic_synchronized);
        } else {
            holder.audioSynchronized.setImageResource(R.drawable.ic_not_synchronized);
        }
    }

    // Get the Size of the list
    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        // The different Views of an item in the list
        public TextView title;
        public TextView rating;
        public TextView yearDuration;
        public TextView cast;
        public ImageView audioSynchronized;

        // Get references to all Views of an item
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.itemMovieTitle);
            rating = itemView.findViewById(R.id.itemMovieRating);
            yearDuration = itemView.findViewById(R.id.itemMovieYearDuration);
            cast = itemView.findViewById(R.id.itemMovieCast);
            audioSynchronized = itemView.findViewById(R.id.itemMovieSynchronized);
        }

    }

}
