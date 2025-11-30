package com.example.test_lab_week_12.api

interface MovieService {
    @GET("movie/popular")
// here, we are using the suspend keyword to indicate that this function is a coroutine
// suspended functions can be paused and resumed at a later time
// this is useful for network calls, since they can take a long time to complete
// and we don't want to block the main thread
// for more info, see: https://kotlinlang.org/docs/flow.html#suspending-functions
    suspend fun getPopularMovies(
        @Query("fd0e3f4ea0d72f78da718a81ce126b8c") apiKey: String
    ): PopularMoviesResponse
}
