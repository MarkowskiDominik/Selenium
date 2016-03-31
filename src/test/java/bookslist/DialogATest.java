package bookslist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bookslist.pages.DialogAPage;
import bookslist.pages.EditBookModalPage;

public class DialogATest extends AbstractSelenium {

	private DialogAPage dialogAPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		dialogAPage = openBooksList().clickLinkDialogA();
		assertFalse(dialogAPage.hasError());
	}

	@Override
	@After
	public void thearDown() {
		super.thearDown();
		dialogAPage = null;
	}

	@Test
	public void dialogAPageHeader() {
		assertEquals("Hello from Dialog A!", dialogAPage.getDialogAHeader());
	}

	@Test
	public void firstRowFromTable() {
		assertEquals("Code Complete Steve McConnell", dialogAPage.getFirstRow().getText());
	}

	@Test
	public void lastRowFromTable() {
		assertEquals("Wzorce projektowe Erich Gamma, Ralph Johnson, Richard Helm, John Vlissides",
				dialogAPage.getLastRow().getText());
	}

	@Test
	public void selectRow() {
		dialogAPage.selectFirstRow();

		assertTrue(dialogAPage.isSelectedRow());
		assertEquals("Code Complete Steve McConnell", dialogAPage.getSelectedRow().getText());
	}

	@Test
	public void unselectRow() {
		dialogAPage.selectFirstRow();
		assertTrue(dialogAPage.isSelectedRow());

		dialogAPage.selectFirstRow();
		assertFalse(dialogAPage.isSelectedRow());
	}

	@Test
	public void selectAnotherRow() {
		dialogAPage.selectFirstRow();
		assertTrue(dialogAPage.isSelectedRow());
		int selectedIndex = dialogAPage.getSelectedRowIndex();

		dialogAPage.selectLastRow();
		assertTrue(dialogAPage.isSelectedRow());
		assertFalse(selectedIndex == dialogAPage.getSelectedRowIndex());
	}

	@Test
	public void isSelectRowAfterReturnFromModalPage() {
		dialogAPage.selectFirstRow();
		assertTrue(dialogAPage.isSelectedRow());
		dialogAPage.openDeleteBookModalDialog().clickCancelButton();

		assertTrue(dialogAPage.isSelectedRow());
	}

	@Test
	public void openAddBookModalPage() {
		assertFalse(dialogAPage.openAddBookModalDialog().hasError());
	}

	@Test
	public void openAddBookModalPageAndCancel() {
		int numberOfRows = dialogAPage.getAllRows().size();

		dialogAPage.openAddBookModalDialog().clickCancelButton();
		assertEquals(numberOfRows, dialogAPage.getAllRows().size());
	}

	@Test
	public void openAddBookModalPageEnterDataAndSave() {
		int numberOfRows = dialogAPage.getAllRows().size();

		dialogAPage.openAddBookModalDialog().setTitle("title").setAuthor("author").clickSaveButton();

		assertFalse(numberOfRows == dialogAPage.getAllRows().size());
		assertEquals("title author", dialogAPage.getLastRow().getText());
	}

	@Test
	public void openEditBookModalPageNoSelectedRow() {
		assertFalse(dialogAPage.isSelectedRow());
		assertTrue(dialogAPage.isDisabledEditButton());
	}

	@Test
	public void openEditBookModalPage() {
		dialogAPage.selectFirstRow();
		assertFalse(dialogAPage.openEditBookModalDialog().hasError());
	}

	@Test
	public void openEditBookModalPageAndCancel() {
		int numberOfRows = dialogAPage.getAllRows().size();

		dialogAPage.selectFirstRow();
		dialogAPage.openEditBookModalDialog().clickCancelButton();

		assertEquals(numberOfRows, dialogAPage.getAllRows().size());
	}

	@Test
	public void openEditBookModalPageEditDataAndSave() {
		int numberOfRows = dialogAPage.getAllRows().size();

		dialogAPage.selectFirstRow();
		EditBookModalPage editBookModalPage = dialogAPage.openEditBookModalDialog();
		editBookModalPage.getTitle().clear();
		editBookModalPage.setTitle("title").clickSaveButton();

		assertEquals(numberOfRows, dialogAPage.getAllRows().size());
		assertEquals("title Steve McConnell", dialogAPage.getFirstRow().getText());
	}

	@Test
	public void openEditBookModalPageTwoTimesAndTestVersionIncrement() {
		dialogAPage.selectFirstRow();
		EditBookModalPage editBookModalPage = dialogAPage.openEditBookModalDialog();
		int version = Integer.parseInt(editBookModalPage.getVersion().getAttribute("value"));
		editBookModalPage.clickSaveButton();

		editBookModalPage = dialogAPage.openEditBookModalDialog();
		assertEquals(version + 1, Integer.parseInt(editBookModalPage.getVersion().getAttribute("value")));
	}

	@Test
	public void openDeleteBookModalPageNoSelectedRow() {
		assertFalse(dialogAPage.isSelectedRow());
		assertTrue(dialogAPage.isDisabledDeleteButton());
	}

	@Test
	public void openDeleteBookModalPage() {
		dialogAPage.selectLastRow();
		assertFalse(dialogAPage.openDeleteBookModalDialog().hasError());
	}

	@Test
	public void openDeleteBookModalPageAndCancel() {
		int numberOfRows = dialogAPage.getAllRows().size();

		dialogAPage.selectLastRow();
		dialogAPage.openDeleteBookModalDialog().clickCancelButton();

		assertEquals(numberOfRows, dialogAPage.getAllRows().size());
	}

	@Test
	public void openDeleteBookModalPageAndDelete() {
		int numberOfRows = dialogAPage.getAllRows().size();
		String lastRow = dialogAPage.getLastRow().getText();

		dialogAPage.selectLastRow();
		dialogAPage.openDeleteBookModalDialog().clickDeleteButton();

		assertFalse(numberOfRows == dialogAPage.getAllRows().size());
		assertFalse(lastRow.equals(dialogAPage.getLastRow().getText()));
	}
}
