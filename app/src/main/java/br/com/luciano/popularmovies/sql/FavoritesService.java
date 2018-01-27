package br.com.luciano.popularmovies.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import javax.inject.Inject;

import br.com.luciano.popularmovies.dto.MovieObject;

public class FavoritesService {

    private final Context context;

    @Inject
    public FavoritesService(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addToFavorites(MovieObject movie) {
        context.getContentResolver().insert(MoviesContract.MovieEntry.CONTENT_URI, movie.toContentValues());
        ContentValues contentValues = new ContentValues();
        contentValues.put(MoviesContract.COLUMN_MOVIE_ID_KEY, movie.getId());
        context.getContentResolver().insert(MoviesContract.Favorites.CONTENT_URI, contentValues);
    }

    public void removeFromFavorites(MovieObject movie) {
        context.getContentResolver().delete(
                MoviesContract.Favorites.CONTENT_URI,
                MoviesContract.COLUMN_MOVIE_ID_KEY + " = " + movie.getId(),
                null
        );
    }

    public boolean isFavorite(MovieObject movie) {
        boolean favorite = false;
        Cursor cursor = context.getContentResolver().query(
                MoviesContract.Favorites.CONTENT_URI,
                null,
                MoviesContract.COLUMN_MOVIE_ID_KEY + " = " + movie.getId(),
                null,
                null
        );
        if (cursor != null) {
            favorite = cursor.getCount() != 0;
            cursor.close();
        }
        return favorite;
    }
}
