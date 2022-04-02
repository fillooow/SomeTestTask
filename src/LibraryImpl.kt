class LibraryImpl : Library {

    private val books: MutableCollection<Book> = HashSet()

    // todo: даблчек на уже существующую книгу
    override fun addNewBook(book: Book) = books.add(book)

    // todo: даблчек на книгу с автором в названии
    override fun deleteBook(id: String) = books.removeIf { it.id == id }

    override fun listBooksByName(searchString: String) = books.filter { it.name.contains(searchString) }
        .take(10)
        .map { it.name }

    override fun listBooksByAuthor(searchString: String) = books.filter { it.author.contains(searchString) }
        .take(10)
        .map { it.name }
}