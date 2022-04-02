
/**
 * The task is to implement the Library interface (you can do that in this file directly).
 * - No database or any other storage is required, just store data in memory
 * - No smart search is required, use String method contains (case sensitive/insensitive - does not matter)
 * - Performance optimizations for listBooksByName and listBooksByAuthor are optional
 */

fun main() {

     test(LibraryImpl())
}

fun test(lib: Library) {

    assertTrue(!lib.deleteBook("1"))
    assertTrue(lib.addNewBook(Book("1", "1", "Lex")))
    assertTrue(!lib.addNewBook(Book("1", "any name because we check id only", "any author")))
    assertTrue(lib.deleteBook("1"))


    assertTrue(lib.addNewBook(Book("3", "Some Book3", "Some Author2")))
    assertTrue(lib.addNewBook(Book("4", "Some Book1", "Some Author3")))
    assertTrue(lib.addNewBook(Book("2", "Some Book2", "Some Author2")))
    assertTrue(lib.addNewBook(Book("1", "Some Book1", "Some Author1")))
    assertTrue(lib.addNewBook(Book("5", "Other Book5", "Other Author4")))
    assertTrue(lib.addNewBook(Book("6", "Other Book6", "Other Author4")))
    assertTrue(lib.addNewBook(Book("7", "Other Book7", "Other Author4")))
    assertTrue(lib.addNewBook(Book("8", "Other Book8", "Other Author4")))
    assertTrue(lib.addNewBook(Book("9", "Other Book9", "Other Author4")))
    assertTrue(lib.addNewBook(Book("10", "Other Book10", "Other Author4")))
    assertTrue(lib.addNewBook(Book("11", "Other Book11", "Other Author4")))

    var byNames = lib.listBooksByName("Book")
    assertTrue(byNames.size == 10)

    byNames = lib.listBooksByName("Some Book")
    assertTrue(byNames.size == 4)
    assertTrue(byNames.contains("Some Author3 - Some Book1"))
    assertTrue(byNames.contains("Some Book2"))
    assertTrue(byNames.contains("Some Book3"))
    assertTrue(!byNames.contains("Some Book1"))
    assertTrue(byNames.contains("Some Author1 - Some Book1"))

    var byAuthor = lib.listBooksByAuthor("Author")
    assertTrue(byAuthor.size == 10)

    byAuthor = lib.listBooksByAuthor("Some Author")
    assertTrue(byAuthor.size == 4)
    assertTrue(byAuthor[0] == "Some Book1")
    assertTrue(byAuthor[1] == "Some Book2" || byAuthor[1] == "Some Book3")
    assertTrue(byAuthor[2] == "Some Book2" || byAuthor[2] == "Some Book3")
    assertTrue(byAuthor[3] == "Some Book1")

    println("All tests complete")
}

fun assertTrue(condition: Boolean) {
    if (!condition) {
        throw Error("assert failed")
    }
}
