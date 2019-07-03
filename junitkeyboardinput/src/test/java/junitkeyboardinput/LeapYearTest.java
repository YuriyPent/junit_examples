package junitkeyboardinput;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class LeapYearTest {

	@Test
	public void isLeapYearTest() throws IOException {
		LeapYear check = new LeapYear();
		assertTrue("Leap Year", check.isLeapYear(2015));
	}

	@Test
	public void isLeapYearKeboardTest() throws IOException {
		LeapYear leapYear = new LeapYear();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter year(yyyy):");
		int year = sc.nextInt();
		assertTrue("Leap Year", leapYear.isLeapYear(year));
		sc.close();
	}

}
