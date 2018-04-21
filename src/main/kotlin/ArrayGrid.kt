
open class ArrayGrid<E>(protected val array: Array<E>, final override val width: Int)
	: BaseGrid<E>() {

	final override fun get(x: Int, y: Int) = array[y * width + x]

	final override val height = array.size / width
}

open class MutableArrayGrid<E>(grid: Array<E>, width: Int)
	: ArrayGrid<E>(grid, width), MutableGrid<E> {

	override fun set(x: Int, y: Int, value: E) {
		array[y * width + x] = value
	}
}

inline fun <reified E> String.toMutableArrayGrid(toValue: (Char) -> E)
		: MutableArrayGrid<E> {

	val s = trimMargin().filter { it != '\n' }
	val array = Array(s.length) { i -> toValue(s[i]) 	}
	val width = trimMargin().lines().first().length

	return MutableArrayGrid(array, width)
}

inline fun <reified E> String.toArrayGrid(toValue: (Char) -> E): ArrayGrid<E> {
	return toMutableArrayGrid { toValue(it) }
}