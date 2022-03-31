class LibraryImpl : Library {

    private val books: MutableCollection<Book> = mutableListOf()

    override fun addNewBook(book: Book) = books.add(book)

    override fun deleteBook(id: String) = books.removeIf { it.id == id }

    override fun listBooksByName(searchString: String) = books.filter { it.name.contains(searchString) }.map { it.name }

    override fun listBooksByAuthor(searchString: String) = books.filter { it.author.contains(searchString) }.map { it.name }
}