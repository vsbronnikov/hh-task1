package org.vsbronnikov.hh;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {

		int[][] points = {};

		// Получаем координаты точек со стандартного входа.
		// Повторное нажатие Enter завершает ввод.

		String sep = System.getProperty("line.separator");
		System.out.println("Введите кооррдинаты точек." + sep
				+ "Каждая точка с новой строки." + sep
				+ "Для завершения ввода нажмите 2 раза Enter.");

		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String line = (String) in.nextLine();

			if (line.isEmpty()) {
				// Повторное нажатие Enter завершает ввод.
				break;
			}

			String[] nums = line.split(" ", 2); // Получаем координаты, разделенные пробелом
			try {
				int len = points.length;
				int x = Integer.parseInt(nums[0]);
				int y = Integer.parseInt(nums[1]);

				// Добавляем новую точку в конец массива.
				
				int[][] temp = new int[len + 1][2];
				System.arraycopy(points, 0, temp, 0, len);

				temp[len][0] = x;
				temp[len][1] = y;

				points = temp;
			} catch (Exception e) {
				// Возможны исключения: либо введены не верные данные (не int),
				// либо не верное количество координат (ожидаем минимум 2).
				continue;
			}
		}

		in.close();

		// Вычисляем минимальное расстояние между точками.
		Minimizer min = new Minimizer();

		System.out.println(min.calc(points));
	}
}
