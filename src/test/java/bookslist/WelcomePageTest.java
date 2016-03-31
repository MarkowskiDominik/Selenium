package bookslist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import bookslist.pages.WelcomePage;

public class WelcomePageTest extends AbstractSelenium {

	private WelcomePage welcomePage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		welcomePage = openBooksList();
	}

	@Test
	public void openDialogAPageByLink() {
		assertFalse(welcomePage.hasError());
		assertEquals("Hello from Dialog A!", welcomePage.clickLinkDialogA().getDialogAHeader());
	}

	@Test
	public void openDialogBPageByLink() {
		assertFalse(welcomePage.hasError());
		assertEquals("Hello from Dialog B!", welcomePage.clickLinkDialogB().getDialogBHeader());
	}

	@Test
	public void openDialogAPageByNavbar() {
		assertFalse(welcomePage.hasError());
		assertEquals("Hello from Dialog A!", welcomePage.clickNavbarDialogA().getDialogAHeader());
	}

	@Test
	public void openDialogBPageByNavbar() {
		assertFalse(welcomePage.hasError());
		assertEquals("Hello from Dialog B!", welcomePage.clickNavbarDialogB().getDialogBHeader());
	}

}
