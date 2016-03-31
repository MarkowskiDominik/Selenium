package bookslist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bookslist.pages.AddBookModalPage;

public class AddBookModalPageTest extends AbstractSelenium {

	private AddBookModalPage addBookModalPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		addBookModalPage = openBooksList().clickNavbarDialogA().openAddBookModalDialog();
		assertFalse(addBookModalPage.hasError());
	}

	@Test
	public void shouldCheckIfTitleIsRequired() {
		addBookModalPage.setAuthor("author").setYear("1990").setGenre("it");

		assertTrue(addBookModalPage.isDisabledSaveButton());
		assertTrue(addBookModalPage.isRequiredTitle());
	}

	@Test
	public void shouldCheckIfAuthorIsRequired() {
		addBookModalPage.setTitle("title").setYear("1990").setGenre("it");

		assertTrue(addBookModalPage.isDisabledSaveButton());
		assertTrue(addBookModalPage.isRequiredAuthor());
	}

	@Test
	public void shouldCheckIfYearIsLessThan1900() {
		addBookModalPage.setTitle("title").setAuthor("author").setYear("1899");

		assertTrue(addBookModalPage.isDisabledSaveButton());
	}

	@Test
	public void shouldCheckIfYearIsGreaterThan2017() {
		addBookModalPage.setTitle("title").setAuthor("author").setYear("2018");

		assertTrue(addBookModalPage.isDisabledSaveButton());
	}

	@Test
	public void shouldCheckIfYearIsInRange() {
		addBookModalPage.setTitle("title").setAuthor("author");

		for (Integer year = 1800; year < 2020; year += 10) {
			addBookModalPage.getYear().clear();
			addBookModalPage.setYear(year.toString());

			if (year < 1900 || 2017 < year) {
				assertTrue(addBookModalPage.isDisabledSaveButton());
			} else {
				assertFalse(addBookModalPage.isDisabledSaveButton());
			}
		}
	}
}
