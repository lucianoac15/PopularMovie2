package br.com.luciano.popularmovies;

import br.com.luciano.popularmovies.api.NetworkModule;
import br.com.luciano.popularmovies.screen.MainActivity;
import br.com.luciano.popularmovies.util.SortingDialogFragment;
import br.com.luciano.popularmovies.screen.MovieDetailActivity;
import br.com.luciano.popularmovies.screen.MovieDetailFragment;
import br.com.luciano.popularmovies.screen.MoviesGridFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {

    void inject(MoviesGridFragment moviesGridFragment);

    void inject(MainActivity mainActivity);

    void inject(SortingDialogFragment sortingDialogFragment);

    void inject(MovieDetailActivity movieDetailActivity);

    void inject(MovieDetailFragment movieDetailFragment);

}
