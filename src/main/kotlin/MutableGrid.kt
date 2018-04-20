
interface MutableGrid<E> : Grid<E> {
	operator fun set(x: Int, y: Int, value: E)

	override var Cell.value: E
		get() = get(x, y)
		set(value) {
			set(x, y, value)
		}
}

fun <E> MutableGrid<E>.swap(x1: Int, y1: Int, x2: Int, y2: Int) {
	val value1 = this[x1, y1]
	this[x1, y1] = this[x2, y2]
	this[x2, y2] = value1
}