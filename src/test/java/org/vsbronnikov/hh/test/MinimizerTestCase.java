package org.vsbronnikov.hh.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vsbronnikov.hh.Minimizer;

public class MinimizerTestCase {

	@Test
	public void test() {

		int[][] points = { { 10, 10 }, { 20, 10 }, { 20, 15 } };

		Minimizer min = new Minimizer();

		assertEquals(5.0, min.calc(points), Double.NaN);
	}
}
