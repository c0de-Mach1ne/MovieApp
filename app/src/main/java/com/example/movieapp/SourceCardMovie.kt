package com.example.movieapp

class SourceCardMovie {
    fun getCardMovie(): List<CardMovie> {
        return listOf(
            CardMovie(
                "Avengers: End Game", "https://i.ibb.co/6n1pQ30/Avengers-End-Game.png", 13,
                "Action, Adventure, Drama", 137, 125, 4, false
            ),
            CardMovie(
                "Tenet", "https://i.ibb.co/wpd8Mgn/Tenet.png", 16,
                "Action, Sci-Fi, Thriller", 97, 98, 5, true
            ),
            CardMovie(
                "Black Window", "https://i.ibb.co/SwNhq1W/Black-Window.png", 13,
                "Action, Adventure, Sci-Fi", 102, 38, 4, false
            ),
            CardMovie(
                "Wonder Woman 1984", "https://i.ibb.co/jJTNcgG/Wonder-Woman-1984.png", 13,
                "Action, Adventure, Fantasy", 120, 74, 5, true
            ),
            CardMovie(
                "Avengers: End Game", "https://i.ibb.co/6n1pQ30/Avengers-End-Game.png", 13,
                "Action, Adventure, Drama", 137, 125, 4, false
            ),
            CardMovie(
                "Tenet", "https://i.ibb.co/wpd8Mgn/Tenet.png", 16,
                "Action, Sci-Fi, Thriller", 97, 98, 3, true
            ),
            CardMovie(
                "Black Window", "https://i.ibb.co/SwNhq1W/Black-Window.png", 13,
                "Action, Adventure, Sci-Fi", 102, 38, 2, false
            ),
            CardMovie(
                "Wonder Woman 1984", "https://i.ibb.co/jJTNcgG/Wonder-Woman-1984.png", 13,
                "Action, Adventure, Fantasy", 120, 74, 1, true
            ),
        )
    }
}