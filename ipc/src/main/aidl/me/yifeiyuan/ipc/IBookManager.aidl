// IBookManager.aidl
package me.yifeiyuan.ipc;

// Declare any non-default types here with import statements

import me.yifeiyuan.ipc.Book;

interface IBookManager {

    List<Book>getBooks();

    boolean addBook(in Book book);

    Book getBookByName(String name);
}
