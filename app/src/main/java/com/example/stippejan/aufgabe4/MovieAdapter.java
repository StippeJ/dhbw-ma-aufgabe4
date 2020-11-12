package com.example.stippejan.aufgabe4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie m = movieList.get(position);
        holder.title.setText(m.getTitle());
        holder.rating.setText(String.format("%.1f", m.getImdbScore()));
        holder.yearDuration.setText(m.getYear() + ", " + m.getDuration());
        holder.cast.setText(m.getCast().toString().replace("[", "").replace("]", ""));
        if (m.getAudioSynchronized()) {
            holder.audioSynchronized.setImageResource(R.drawable.ic_synchronized);
        } else {
            holder.audioSynchronized.setImageResource(R.drawable.ic_not_synchronized);
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView rating;
        public TextView yearDuration;
        public TextView cast;
        public ImageView audioSynchronized;

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
