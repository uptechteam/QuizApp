package model

enum class Category(val title: String, val id: Int) {
    GENERAL_KNOWLEDGE("General Knowledge", 9),
    BOOKS("Entertainment: Books", 10),
    FILM("Entertainment: Film", 11),
    MUSIC("Entertainment: Music", 12),
    MUSICALS_THEATERS("Entertainment: Musicals & Theatres", 13),
    TELEVISION("Entertainment: Television", 14),
    VIDEO_GAMES("Entertainment: Video Games", 15),
    BOARD_GAMES("Entertainment: Board Games", 16),
    SCIENCE_NATURE("Science & Nature", 17),
    COMPUTERS("Science: Computers", 18),
    MATHEMATICS("Science: Mathematics", 19),
    MYTHOLOGY("Mythology", 20),
    SPORTS("Sports", 21),
    GEOGRAPHY("Geography", 22),
    HISTORY("History", 23),
    POLITICS("Politics", 24),
    ART("Art", 25),
    CELEBRITIES("Celebrities", 26),
    ANIMALS("Animals", 27),
    VENICLES("Vehicles", 28),
    COMICS("Entertainment: Comics", 29),
    GADGETS("Science: Gadgets", 30),
    JAPANESE_ANIME_MANGA("Entertainment: Japanese Anime & Manga", 31),
    CARTOON_ANIMATIONS("Entertainment: Cartoon & Animations", 32)
}
