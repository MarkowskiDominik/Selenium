package bookslist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
	
}
