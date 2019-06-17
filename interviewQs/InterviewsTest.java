package interviewQs;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class InterviewsTest {

//	@Test
	void closedBrackets() {
		assertEquals(false, Interviews.closedBrackets(""));
		assertEquals(true, Interviews.closedBrackets("abcdef"));
		assertEquals(true, Interviews.closedBrackets("adjs{jfds(fj)jfd}"));
		assertEquals(false, Interviews.closedBrackets("[abcde}"));
		assertEquals(false, Interviews.closedBrackets("ab[jks)jfhs)"));
		assertEquals(true, Interviews.closedBrackets("[avd]"));
		assertEquals(true, Interviews.closedBrackets("[ajds(sjf)jf]"));
		assertEquals(true, Interviews.closedBrackets("[ads{d(f)jfd}a]"));
		assertEquals(true, Interviews.closedBrackets("[]()"));
		
	}
	
	@Test
	void firstUniqChar() {
		assertEquals(-1, Interviews.firstUniqChar("cc"));
	}
	
//	@Test
//	void findBounds() {
//		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
//		assertEquals("[-1, -1]", Interviews.findBounds(array, 10));
//		int[] array1 = new int[] {1, 2, 2, 2, 2, 2, 7, 8};
//		assertEquals("[1, 5]", Interviews.findBounds(array1, 2));
//		int[] array2 = new int[] {1, 2, 2, 3, 6, 6, 7, 8};
//		assertEquals("[1, 2]", Interviews.findBounds(array2, 2));
//		int[] array3 = new int[] {1, 2, 2, 3, 3, 6, 6, 6};
//		assertEquals("[5, 7]", Interviews.findBounds(array3, 6));
//	}

}
