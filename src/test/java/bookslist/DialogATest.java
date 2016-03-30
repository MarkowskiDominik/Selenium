package bookslist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bookslist.pages.DialogAPage;

public class DialogATest extends AbstractSelenium {

	private DialogAPage dialogAPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		dialogAPage = openBooksList().clickLinkDialogA();
	}

	@Override
	@After
	public void thearDown() {
		super.thearDown();
		dialogAPage = null;
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
	public void selectedRow() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertTrue(dialogAPage.isSelectedRow());
		assertEquals("Code Complete Steve McConnell", dialogAPage.getSelectedRow().getText());
	}

	@Test
	public void unSelectedRow() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertTrue(dialogAPage.isSelectedRow());
		dialogAPage.selectFirstRow();
		assertFalse(dialogAPage.isSelectedRow());
	}

	@Test
	public void openAddBookModalPage() {
		assertFalse(dialogAPage.hasError());
		assertEquals("Add book", dialogAPage.openAddBookModalDialog().getAddBookModalPageHeader());
	}
	
	@Test
	public void openEditBookModalPageNoSelectedRow() {
		assertFalse(dialogAPage.hasError());
		assertFalse(dialogAPage.isSelectedRow());
		assertTrue(dialogAPage.isDisabledEditButton());
	}

	@Test()
	public void openEditBookModalPage() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertEquals("Edit book", dialogAPage.openEditBookModalDialog().getEditBookModalPageHeader());
	}

	@Test
	public void openDeleteBookModalPageNoSelectedRow() {
		assertFalse(dialogAPage.hasError());
		assertFalse(dialogAPage.isSelectedRow());
		assertTrue(dialogAPage.isDisabledDeleteButton());
	}

	@Test()
	public void openDeleteBookModalPage() {
		assertFalse(dialogAPage.hasError());
		dialogAPage.selectFirstRow();
		assertEquals("Delete book?", dialogAPage.openDeleteBookModalDialog().getDeleteBookModalPageHeader());
	}
	
}
