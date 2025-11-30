package com.example.test_lab_week_12

import androidx.lifecycle.ViewModel

class MovieViewModel(private val movieRepository: MovieRepository)
    : ViewModel() {
    init {
        fetchPopularMovies()
    }
    private val _popularMovies = MutableStateFlow(
        emptyList<Movie>()
    )
    val popularMovies: StateFlow<List<Movie>> = _popularMovies
    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error
    // fetch movies from the API
    private fun fetchPopularMovies() {
// launch a coroutine in viewModelScope
// Dispatchers.IO means that this coroutine will run on a shared pool of threads
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.fetchMovies().catch {
// catch is a terminal operator that catches exceptions
                from the Flow
                _error.value = "An exception occurred: ${it.message}"
            }.collect {
// collect is a terminal operator that collects the values from the Flow
// the results are emitted to the StateFlow
                        _popularMovies.value = it
            }
        }
    }

}
}
