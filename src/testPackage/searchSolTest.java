package testPackage;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import finalsol.searchSol;

public class searchSolTest {


	@Test
	public void test1() {

		int n=2;
		int[] keyArray={1, 4, 7};
		int[] locationArray={0, 2, 4};

		searchSol s=new searchSol(keyArray, locationArray, n);
		//System.out.println(s.getSteps());
		int actual[]=s.getPath();
		int[] expected={0, 1, 3, 2, 5, 6, 4};


		Assert.assertArrayEquals( expected, actual );
		assertEquals(s.getSteps(), 29);
		s.resetStaticFields();

	}

	@Test
	public void test2() {

		int n=3;
		int[] keyArray={1, 7, 14, 16, 17, 19};
		int[] locationArray={17, 10, 1, 3, 7, 16};
		
		
		searchSol s=new searchSol(keyArray, locationArray, n);
		//System.out.println(Arrays.toString(s.getPath()));
		//System.out.println(s.getSteps());

		
		int actual[]=s.getPath();
		int[] expected={17, 13, 8, 4, 5, 9, 10, 14, 18, 15, 11, 6, 2, 1, 0, 3, 7, 12, 16};


		Assert.assertArrayEquals( expected, actual );
		assertEquals(s.getSteps(), 564);

		s.resetStaticFields();


	}
	
	@Test
	public void test3() {

		int n=3;
		int[] keyArray={1, 6, 12, 14, 16, 19};
		int[] locationArray={5, 8, 18, 9, 15, 2};
		
		searchSol s=new searchSol(keyArray, locationArray, n);
		//System.out.println(Arrays.toString(s.getPath()));
		//System.out.println(s.getSteps());

		int actual[]=s.getPath();
		int[] expected={5, 1, 0, 3, 4, 8, 7, 12, 13, 16, 17, 18, 14, 9, 10, 15, 11, 6, 2};


		Assert.assertArrayEquals( expected, actual );
		assertEquals(s.getSteps(), 145);

		s.resetStaticFields();


	}
	
	@Test
	public void test4() {

		int n=4;
		int[] keyArray={1, 4, 16, 17, 22, 24, 26, 29, 31, 33, 37};
		int[] locationArray={20, 2, 18, 12, 22, 29, 34, 35, 32, 27, 3};
		
		searchSol s=new searchSol(keyArray, locationArray, n);
		//System.out.println(Arrays.toString(s.getPath()));
		//System.out.println(s.getSteps());

		int actual[]=s.getPath();
		int[] expected={20, 13, 7, 2, 1, 0, 4, 5, 6, 11, 10, 9, 15, 16, 17, 18, 12, 19, 25, 24, 23, 22, 28, 29, 33, 34, 30, 31, 35, 36, 32, 26, 27, 21, 14, 8, 3};


		Assert.assertArrayEquals( expected, actual );
		assertEquals(s.getSteps(), 280);

		s.resetStaticFields();


	}
	
	@Test
	public void test5() {

		int n=5;
		int[] keyArray={1, 3, 4, 6, 7, 8, 9, 14, 16, 18, 29, 31, 32, 35, 41, 44, 47, 59, 61};
		int[] locationArray={44, 27, 18, 5, 0, 1, 2, 7, 12, 14, 28, 30, 31, 25, 38, 46, 49, 43, 26};
		
		searchSol s=new searchSol(keyArray, locationArray, n);
		//System.out.println(Arrays.toString(s.getPath()));
		//System.out.println(s.getSteps());

		
		int actual[]=s.getPath();
		int[] expected={44, 36, 27, 18, 11, 5, 0, 1, 2, 3, 4, 9, 8, 7, 6, 12, 13, 14, 15, 16, 10, 17, 24, 23, 22, 21, 20, 19, 28, 29, 30, 31, 32, 33, 25, 34, 42, 41, 40, 39, 38, 37, 45, 46, 47, 48, 49, 55, 54, 60, 59, 53, 52, 58, 57, 51, 56, 50, 43, 35, 26};


		Assert.assertArrayEquals( expected, actual );
		assertEquals(s.getSteps(), 2995);

		s.resetStaticFields();


	}

}
