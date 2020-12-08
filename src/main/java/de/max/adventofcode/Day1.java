package de.max.adventofcode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * TODO Klasse kommentieren
 * 
 * @author rumforma
 * @version $Revision:$<br/>
 *          $Date:$<br/>
 *          $Author:$
 */
public class Day1 {

	public static List<String> input;

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		System.out.println("Starting at: " + LocalDateTime.now());

		input = Utils.getListFromFilename("input-day1.txt");
		part1();
		part2();

		long end = System.currentTimeMillis();
		System.out.println("Finishing at: " + LocalDateTime.now());
		System.out.println("Runtime: " + (end - start) + "ms");

	}

	private static void part1() {
		Integer floor = 0;
		char[] directions = input.get(0).toCharArray();
		for (char direction : directions) {
			switch (direction) {
			case '(':
				floor++;
				break;
			case ')':
				floor--;
				break;
			default:
				break;
			}
		}
		System.out.println("Now on floor " + floor);
	}

	private static void part2() {
		Integer floor = 0;
		char[] directions = input.get(0).toCharArray();
		for (int i = 0; i < directions.length; i++) {
			switch (directions[i]) {
			case '(':
				floor++;
				break;
			case ')':
				floor--;
				break;
			default:
				break;
			}
			if (floor < 0) {
				System.out.println("Entering basement on statement " + (i + 1));
				break;
			}
		}
	}

}
