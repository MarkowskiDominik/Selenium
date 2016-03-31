package bookslist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bookslist.pages.DialogAPage;
import bookslist.pages.EditBookModalPage;

public class EditBookModalPageTest extends AbstractSelenium {

	private EditBookModalPage editBookModalPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		DialogAPage dialogAPage = openBooksList().clickNavbarDialogA();
		dialogAPage.selectFirstRow();
		editBookModalPage = dialogAPage.openEditBookModalDialog();
		assertFalse(editBookModalPage.hasError());
	}

	@Test
	public void shouldCheckIfTitleIsRequired() {
		editBookModalPage.getTitle().clear();

		assertTrue(editBookModalPage.isDisabledSaveButton());
		assertTrue(editBookModalPage.isRequiredTitle());
	}

	@Test
	public void shouldCheckIfAuthorIsRequired() {
		editBookModalPage.getAuthor().clear();

		assertTrue(editBookModalPage.isDisabledSaveButton());
		assertTrue(editBookModalPage.isRequiredAuthor());
	}

	@Test
	public void shouldCheckIfYearIsLessThan1900() {
		editBookModalPage.getYear().clear();
		editBookModalPage.setYear("1899");

		assertTrue(editBookModalPage.isDisabledSaveButton());
	}

	@Test
	public void shouldCheckIfYearIsGreaterThan2017() {
		editBookModalPage.getYear().clear();
		editBookModalPage.setYear("2018");

		assertTrue(editBookModalPage.isDisabledSaveButton());
	}

	@Test
	public void shouldCheckIfYearIsInRange() {
		editBookModalPage.getYear().clear();

		for (Integer year = 1800; year < 2020; year += 10) {
			editBookModalPage.getYear().clear();
			editBookModalPage.setYear(year.toString());

			if (year < 1900 || 2017 < year) {
				assertTrue(editBookModalPage.isDisabledSaveButton());
			} else {
				assertFalse(editBookModalPage.isDisabledSaveButton());
			}
		}
	}
}
