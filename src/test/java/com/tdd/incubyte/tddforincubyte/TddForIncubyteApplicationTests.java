package com.tdd.incubyte.tddforincubyte;

import com.tdd.incubyte.tddforincubyte.config.log.TestLogger;
import com.tdd.incubyte.tddforincubyte.utils.string.StringCalculatorUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestLogger.class)
@SpringBootTest
class TddForIncubyteApplicationTests {

	@Test
	public void testEmptyString() {
		System.out.println("Testing an empty string should return 0.");
		assertEquals(0, StringCalculatorUtils.Add(""));
	}

	@Test
	public void testSingleNumber() {
		System.out.println("Testing a single number should return that number.");
		assertEquals(1, StringCalculatorUtils.Add("1"));
	}

	@Test
	public void testTwoNumbers() {
		System.out.println("Testing the addition of two numbers.");
		assertEquals(3, StringCalculatorUtils.Add("1,2"));
	}

	@Test
	public void testMultipleNumbers() {
		System.out.println("Testing the addition of multiple numbers.");
		assertEquals(6, StringCalculatorUtils.Add("1\n2,3"));
	}

	@Test
	public void testDifferentDelimiter() {
		System.out.println("Testing with a custom delimiter.");
		assertEquals(3, StringCalculatorUtils.Add("//;\n1;2"));
	}

	@Test
	public void testNegativeNumber() {
		System.out.println("Testing for negative numbers should throw an exception.");
		assertThrows(IllegalArgumentException.class, () -> StringCalculatorUtils.Add("1,-2,3"));
	}

	@Test
	public void testMultipleNegativeNumbers() {
		try {
			System.out.println("Testing for multiple negative numbers should throw an exception.");
			StringCalculatorUtils.Add("-1,2,-3");
			fail("Exception should have been thrown for negative numbers");
		} catch (IllegalArgumentException e) {
			assertEquals("Negatives not allowed: -1, -3", e.getMessage());
		}
	}

	@Test
	public void testNumbersGreaterThan1000() {
		System.out.println("Testing for numbers greater than 1000 should ignore them.");
		assertEquals(2, StringCalculatorUtils.Add("1001,2"));
	}

}
