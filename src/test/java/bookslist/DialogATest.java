package bookslist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;

import bookslist.pages.AddBookModalPage;
import bookslist.pages.DialogAPage;

public class DialogATest extends AbstractSelenium {

	private DialogAPage dialogAPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		dialogAPage = openBooksList().clickLinkDialogA();
	}

	@Test
	public void dialogAPageHeader() {
		assertFalse(dialogAPage.hasError());
		assertEquals("Hello from Dialog A!", dialogAPage.getDialogAHeader());
	}
	
	@Test
	public void firstTitleFromTable() {
		assertFalse(dialogAPage.hasError());
		assertEquals("Code Complete", dialogAPage.getFirstTitleFromTable());
	}

	@Test
	public void lastTitleFromTable() {
		assertFalse(dialogAPage.hasError());
		assertEquals("Wzorce projektowe", dialogAPage.getLastTitleFromTable());
	}
	
	@Test
	public void openAddBookModalPage() {
		assertFalse(dialogAPage.hasError());
		AddBookModalPage addDialog = dialogAPage.openAddBookModalDialog();
		assertEquals("Add book", addDialog.getAddBookModalPageHeader());
	}
	
	@Test(expected = InvalidSelectorException.class)
	public void openEditBookModalPageNoSelectedRow() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.openEditBookModalDialog();
	}

	@Test(expected = InvalidSelectorException.class)
	public void openDeleteBookModalPageNoSelectedRow() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.openDeleteBookModalDialog();
	}

	@Test
	public void selectedRow() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertEquals("Code Complete Steve McConnell", dialogAPage.getSelectedRow().getText());
	}

	@Test(expected = NoSuchElementException.class)
	public void unSelectedRow() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		dialogAPage.selectFirstRow();
		dialogAPage.getSelectedRow().getText();
	}
	
	@Test()
	public void openEditBookModalPage() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertEquals("Edit book", dialogAPage.openEditBookModalDialog().getEditBookModalPageHeader());
	}
	
	@Test()
	public void openDeleteBookModalPage() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertEquals("Delete book?", dialogAPage.openDeleteBookModalDialog().getDeleteBookModalPageHeader());
	}
	
}
