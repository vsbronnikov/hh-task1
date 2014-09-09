package org.vsbronnikov.hh;

/**
 * Вычисляет минимальное расстояние между двумя точками, координаты которых
 * заданы в виде двумерного массива.
 * 
 * @author VBronnikov
 *
 */
public class Minimizer {

	public double calc(int[][] points) {

		// Индекс уже обработанной точки, для исключения повторов.
		int startIndex = 1;

		// Результат, минимальное расстояние между точками.
		double result = -1;

		for (int i = 0; i <= points.length - 1; i++) {
			int[] startPoint = points[i]; // Начальная точка

			for (int j = startIndex; j <= points.length - 1; j++) {
				int[] endPoint = points[j]; // Конечная точка

				// Геометрическое условие "катет всегда меньше гепотенузы".
				if (result >= 0
						&& (Math.abs(startPoint[0] - endPoint[0]) >= result || Math
								.abs(startPoint[1] - endPoint[1]) >= result)) {
					continue;
				}

				// Возможно еще сравнить длину катетов двух текущих точек и
				// точек, которые на данный момент образуют минимальный отрезок.
				// Но это небольшое отсечение точек из всего множества.

				double currentLength = Math.sqrt(Math.pow(startPoint[0]
						- points[j][0], 2)
						+ Math.pow(startPoint[1] - points[j][1], 2));
				if (result < 0 || currentLength < result) {
					result = currentLength;
				}
			}

			startIndex++;
		}

		return result;
	}
}
