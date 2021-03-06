package com.vincentcarrier.kgrid.core


fun <E> Grid<E>.column(x: Int, startingPoint: Int = 0): Iterable<Cell> {
	return Iterable {
		object : Iterator<Cell> {
			var i = startingPoint

			override fun hasNext() = i < height

			override fun next() = Cell(x, i).also { i++ }
		}
	}
}

fun <E> Grid<E>.row(y: Int, startingPoint: Int = 0): Iterable<Cell> {
	return Iterable {
		object : Iterator<Cell> {
			var i = startingPoint

			override fun hasNext() = i < width

			override fun next() = Cell(i, y).also { i++ }
		}
	}
}

