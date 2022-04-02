class LibraryImpl : Library {

    private companion object {

        const val ITEMS_TO_TAKE = 10
    }

    private val books: MutableCollection<Book> = HashSet()

    override fun addNewBook(book: Book) = books.add(book)

    override fun deleteBook(id: String) = books.removeIf { it.id == id }

    override fun listBooksByName(searchString: String): Collection<String> {

        val takenBooks = books.filter { it.name.contains(searchString) }.take(ITEMS_TO_TAKE)

        val duplicates = takenBooks.groupingBy { it.name }.eachCount().filter { it.value > 1 }.map { it.key }

        return when (duplicates.isEmpty()) {

            true -> takenBooks.map { it.name }
            else -> takenBooks.map { taken ->

                when (duplicates.contains(taken.name)) {

                    true -> "${taken.author} - ${taken.name}"
                    else -> taken.name
                }
            }
        }
    }

    override fun listBooksByAuthor(searchString: String) = books.filter { it.author.contains(searchString) }
        .take(ITEMS_TO_TAKE)
        .map { it.name }
}