package de.max.adventofcode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO Klasse kommentieren
 * 
 * @author rumforma
 * @version $Revision:$<br/>
 *          $Date:$<br/>
 *          $Author:$
 */
public class Day2 {

	public static List<String> input;

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		System.out.println("Starting at: " + LocalDateTime.now());

		input = Utils.getListFromFilename("input-day2.txt");
		part1();
		part2();

		long end = System.currentTimeMillis();
		System.out.println("Finishing at: " + LocalDateTime.now());
		System.out.println("Runtime: " + (end - start) + "ms");

	}

	private static void part1() {
		Integer totalSheetNeeded = 0;

		for (String present : input) {
			Integer sheetNeeded = calculateNeededPaperForPresent(present);
			totalSheetNeeded += sheetNeeded;
		}
		System.out.println("Total sheet needed: " + totalSheetNeeded);

	}

	private static void part2() {
		Integer totalRibbonNeeded = 0;
		for (String present : input) {
			Integer ribbonNeeded = calculateNeededRibbonForPresent(present);
			totalRibbonNeeded += ribbonNeeded;
		}
		System.out.println("Total ribbon needed: " + totalRibbonNeeded);
	}

	private static Integer calculateNeededRibbonForPresent(String present) {
		String[] dimensions = present.split("x");

		List<Integer> sides = new ArrayList<>();
		sides.add(Integer.parseInt(dimensions[0]));
		sides.add(Integer.parseInt(dimensions[1]));
		sides.add(Integer.parseInt(dimensions[2]));

		Collections.sort(sides);

		Integer volume = sides.get(0) * sides.get(1) * sides.get(2);
		Integer shortestCircumference = 2 * sides.get(0) + 2 * sides.get(1);
		return volume + shortestCircumference;
	}

	private static Integer calculateNeededPaperForPresent(String present) {
		String[] dimensions = present.split("x");
		Integer length = Integer.parseInt(dimensions[0]);
		Integer width = Integer.parseInt(dimensions[1]);
		Integer height = Integer.parseInt(dimensions[2]);

		List<Integer> sideSurfaces = new ArrayList<>();
		sideSurfaces.add(length * width);
		sideSurfaces.add(width * height);
		sideSurfaces.add(height * length);

		Collections.sort(sideSurfaces);

		return 3 * sideSurfaces.get(0) + 2 * sideSurfaces.get(1) + 2 * sideSurfaces.get(2);
	}

}
