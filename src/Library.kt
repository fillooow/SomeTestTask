interface Library {

    /**
    Adds a new book object to the Library.
    @param book: book to add to the Library
    @return false if the book with same id already exists in the Library, true – otherwise.
     */
    fun addNewBook(book: Book): Boolean

    /**
    Deletes the book with the specified id from the Library.
    @return true if the book with same id existed in the Library, false – otherwise.
     */
    fun deleteBook(id: String): Boolean

    /**
    @return 10 book names containing the specified string.
    If there are several books with the same name, author's name is added to book's name in the format "<author> - <book>",
    otherwise returns simply "<book>".
     */
    fun listBooksByName(searchString: String): Collection<String>

    /**
    @return 10 book names whose author contains the specified string,
    result is ordered by authors.
     */
    fun listBooksByAuthor(searchString: String): List<String>
}